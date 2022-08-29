package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.CartDTO;
import com.mycompany.spring_mvc_project_final.entities.Category;
import com.mycompany.spring_mvc_project_final.entities.Image;
import com.mycompany.spring_mvc_project_final.entities.Product;
import com.mycompany.spring_mvc_project_final.service.AccountService;
import com.mycompany.spring_mvc_project_final.service.CategoryService;
import com.mycompany.spring_mvc_project_final.service.ProductService;
import com.mycompany.spring_mvc_project_final.utils.Utils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    ProductService productService;

    @Autowired
    AccountService accountService;
    
    @Autowired
    CategoryService cateService;
    
    @ModelAttribute
    public void commonAttribute(Model model, HttpSession session) {
        List<Category> cates = cateService.getCategories();
        model.addAttribute("cates", cates);
        model.addAttribute("cartCounter", Utils.countCart((Map<Long, CartDTO>) session.getAttribute("cart")));
    }
    
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.toString();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }
        
        List<Product> listProduct = productService.getProducts();
        List<Product> listNewestProduct = productService.getNewestProduct();
        double minPrice = listNewestProduct.get(0).getPrice();
        for(Product p: listNewestProduct){
            if(p.getPrice() < minPrice){
                minPrice = p.getPrice();
                p.getImages().size();
            }
        }
        model.addAttribute("listProduct", listProduct);
        model.addAttribute("listNewestProduct", listNewestProduct);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("username", username);
        // sp moi nhat + tat ca sp

        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerView(Model model) {
        Account user = new Account();
        Map<String, String> genderMap = new HashMap<>();
        genderMap.put("male", "Male");
        genderMap.put("female", "Female");
        model.addAttribute("user", user);
        model.addAttribute("genderMap", genderMap);

        return "user/page-register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute(value = "user") Account user) {
        String errMsg = "";
        if (!user.getPassword()
                .isEmpty() || user.getPassword().equals(user.getConfirmPassword())) {
            accountService.addUser(user);
            return "redirect:/login";
        } else {
            errMsg = "Mat khau khong dung, vui long nhap lai!";
            model.addAttribute("errMsg", errMsg);
            return "/register";
        }
    }

    @RequestMapping(value = "/viewUploadForm", method = RequestMethod.GET)
    public String submitLink(Model model) {
        model.addAttribute("productImages", new Image());
        return "multipart/form-data";
    }

    @RequestMapping(value = "/uploadMultifile", method = RequestMethod.POST)
    public String upload(@ModelAttribute("productImages") Image image, HttpServletRequest request, Model model) {

        return this.doUpload(request, model, image);

    }

    @RequestMapping(value = "/login")
    public String login() {
        return "user/page-login";
    }
    
    @RequestMapping(value = "/logout")
    public String logout() {
        return "/";
    }

    @RequestMapping(value = "/checkout")
    public String checkout() {
        return "user/page-checkout";
    }



    @RequestMapping("/403")
    public String accessDenied(Model model) {
        return "403Page";
    }

    private String doUpload(HttpServletRequest request, Model model, Image image) {
//        String uploadRootPath = request.getServletContext().getRealPath("/resources/image");
        String uploadRootPath = "D:\\DO AN 2022\\EComerce-Website\\src\\main\\webapp\\resources\\image";        
        
        File uploadRootDir = new File(uploadRootPath);
        // Tạo thư mục gốc upload nếu nó không tồn tại.
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        CommonsMultipartFile[] fileDatas = image.getFileDatas();
        List<File> uploadedFiles = new ArrayList<File>();
        for (CommonsMultipartFile fileData : fileDatas) {
            // Tên file gốc tại Client.
            String name = fileData.getOriginalFilename();
            if (name != null && name.length() > 0) {
                try {
                    // Tạo file tại Server.
                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);

                    // Luồng ghi dữ liệu vào file trên Server.
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(fileData.getBytes());
                    stream.close();
                    //
                    uploadedFiles.add(serverFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        for(File f : uploadedFiles){
            f.getName();
        }
        model.addAttribute("uploadedFiles", uploadedFiles);
        return "multipart/viewFile";
    }
}
