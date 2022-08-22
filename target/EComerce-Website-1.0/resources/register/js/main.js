(function($) {

    $(".toggle-password").click(function() {

        $(this).toggleClass("zmdi-eye zmdi-eye-off");
        var input = $($(this).attr("toggle"));
        if (input.attr("type") == "password") {
          input.attr("type", "text");
        } else {
          input.attr("type", "password");
        }
      });

})(jQuery);

function checkValid () {
  var cbChecked = $("#agree-term").is(":checked");  
  $("#submit").prop("disabled", !cbChecked);
}

$( function () {
  checkValid(); // run it for the first time
  $("#agree-term").on("change", checkValid);  
});