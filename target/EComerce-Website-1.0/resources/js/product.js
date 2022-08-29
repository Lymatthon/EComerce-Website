/* JS Document */

/******************************
 
 [Table of Contents]
 
 1. Vars and Inits
 2. Set Header
 3. Init Menu
 4. Init SVG
 5. Init Product Slider
 
 
 ******************************/

$(document).ready(function ()
{
    "use strict";

    /* 
     
     1. Vars and Inits
     
     */

    var header = $('.header');

    initMenu();
    initSvg();
    initProductSlider();

    setHeader();

    $(window).on('resize', function ()
    {
        setHeader();
    });

    $(document).on('scroll', function ()
    {
        setHeader();
    });

    /* 
     
     2. Set Header
     
     */

    function setHeader()
    {
        if ($(window).scrollTop() > 91)
        {
            header.addClass('scrolled');
        } else
        {
            header.removeClass('scrolled');
        }
    }

    /* 
     
     3. Init Menu
     
     */

    function initMenu()
    {
        if ($('.menu').length)
        {
            var hamburger = $('.hamburger');
            var header = $('.header');
            var superContainerInner = $('.super_container_inner');
            var superOverlay = $('.super_overlay');
            var headerOverlay = $('.header_overlay');
            var menu = $('.menu');
            var isActive = false;

            hamburger.on('click', function ()
            {
                superContainerInner.toggleClass('active');
                menu.toggleClass('active');
                header.toggleClass('active');
                isActive = true;
            });

            superOverlay.on('click', function ()
            {
                if (isActive)
                {
                    superContainerInner.toggleClass('active');
                    menu.toggleClass('active');
                    header.toggleClass('active');
                    isActive = false;
                }
            });

            headerOverlay.on('click', function ()
            {
                if (isActive)
                {
                    superContainerInner.toggleClass('active');
                    menu.toggleClass('active');
                    header.toggleClass('active');
                    isActive = false;
                }
            });
        }
    }

    /* 
     
     4. Init SVG
     
     */

    function initSvg()
    {
        if ($('img.svg').length)
        {
            jQuery('img.svg').each(function ()
            {
                var $img = jQuery(this);
                var imgID = $img.attr('id');
                var imgClass = $img.attr('class');
                var imgURL = $img.attr('src');

                jQuery.get(imgURL, function (data)
                {
                    // Get the SVG tag, ignore the rest
                    var $svg = jQuery(data).find('svg');

                    // Add replaced image's ID to the new SVG
                    if (typeof imgID !== 'undefined') {
                        $svg = $svg.attr('id', imgID);
                    }
                    // Add replaced image's classes to the new SVG
                    if (typeof imgClass !== 'undefined') {
                        $svg = $svg.attr('class', imgClass + ' replaced-svg');
                    }

                    // Remove any invalid XML tags as per http://validator.w3.org
                    $svg = $svg.removeAttr('xmlns:a');

                    // Replace image with new SVG
                    $img.replaceWith($svg);
                }, 'xml');
            });
        }
    }

    /* 
     
     5. Init Product Slider
     
     */

    function initProductSlider()
    {
        var carousel = $('#carousel');
        var prev = $('.fs_prev');
        var next = $('.fs_next');
        var slideCount = $('#carousel .slides > li').length;
        carousel.flexslider(
                {
                    animation: "slide",
                    direction: 'vertical',
                    reverse: false,
                    controlNav: false,
                    directionNav: false,
                    animationLoop: false,
                    slideshow: false,
                    animationSpeed: 300,
                    after: function (slider)
                    {
                        var i = slider.currentSlide;
                        console.log(i);
                        if (i === 0)
                        {
                            prev.addClass('disabled');
                        } else
                        {
                            prev.removeClass('disabled');
                        }

                        if (i < (slideCount - 3))
                        {
                            next.removeClass('disabled');
                        } else
                        {
                            next.addClass('disabled');
                        }
                    }
                });

        $('#slider').flexslider(
                {
                    animation: "slide",
                    direction: 'vertical',
                    controlNav: false,
                    directionNav: false,
                    animationLoop: false,
                    slideshow: false
                });

        var thumbs = $('#carousel .slides > li');
        thumbs.each(function ()
        {
            var thumb = $(this);
            thumb.on('click', function ()
            {
                var selectedIndex = thumbs.index(thumb);
                $('#slider').flexslider(selectedIndex);
            });
        });

        // Custom Navigation
        if (prev.length)
        {
            prev.on('click', function ()
            {
                if (!prev.hasClass('disabled'))
                {
                    $('#carousel').flexslider('prev');
                }
            });
        }

        if (next.length)
        {
            var next = $('.fs_next');
            next.on('click', function ()
            {
                if (!next.hasClass('disabled'))
                {
                    $('#carousel').flexslider('next');
                }
            });
        }
    }
    
});

$('.btn-number').click(function (e) {
        e.preventDefault();

        var fieldName = $(this).attr('data-field');
        var type = $(this).attr('data-type');
        var input = $("input[name='" + fieldName + "']");
        var currentVal = parseInt(input.val());
        if (!isNaN(currentVal)) {
            if (type === 'minus') {

                if (currentVal > input.attr('min')) {
                    input.val(currentVal - 1).change();
                }
                if (parseInt(input.val()) === input.attr('min')) {
                    $(this).attr('disabled', true);
                }

            } else if (type === 'plus') {

                if (currentVal < input.attr('max')) {
                    input.val(currentVal + 1).change();
                }
                if (parseInt(input.val()) === input.attr('max')) {
                    $(this).attr('disabled', true);
                }

            }
        } else {
            input.val(0);
        }
    });
    $('.input-number').focusin(function () {
        $(this).data('oldValue', $(this).val());
    });
    $('.input-number').change(function () {

        var minValue = parseInt($(this).attr('min'));
        var maxValue = parseInt($(this).attr('max'));
        var valueCurrent = parseInt($(this).val());

        var name = $(this).attr('name');
        if (valueCurrent >= minValue) {
            $(".btn-number[data-type='minus'][data-field='" + name + "']").removeAttr('disabled');
        } else {
            alert('Sorry, the minimum value was reached');
            $(this).val($(this).data('oldValue'));
        }
        if (valueCurrent <= maxValue) {
            $(".btn-number[data-type='plus'][data-field='" + name + "']").removeAttr('disabled');
        } else {
            alert('Sorry, the maximum value was reached');
            $(this).val($(this).data('oldValue'));
        }
    });

    $(".input-number").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 190]) !== -1 ||
                // Allow: Ctrl+A
                        (e.keyCode === 65 && e.ctrlKey === true) ||
                        // Allow: home, end, left, right
                                (e.keyCode >= 35 && e.keyCode <= 39)) {
                    // let it happen, don't do anything
                    return;
                }
                // Ensure that it is a number and stop the keypress
                if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
                    e.preventDefault();
                }
            });






    