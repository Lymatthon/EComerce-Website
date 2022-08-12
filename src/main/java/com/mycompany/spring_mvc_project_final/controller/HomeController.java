package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.Image;
import com.mycompany.spring_mvc_project_final.entities.Product;
import com.mycompany.spring_mvc_project_final.entities.RoleEntity;
import com.mycompany.spring_mvc_project_final.enums.Role;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import com.mycompany.spring_mvc_project_final.repository.AccountRepository;
import com.mycompany.spring_mvc_project_final.service.ProductService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @Autowired
    AccountRepository accountRepo;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        List<Product> listProduct = productService.getProducts();
        List<Product> listNewestProduct = productService.getNewestProduct();
        double minPrice = listNewestProduct.get(0).getPrice();
        model.addAttribute("listProduct", listProduct);
        model.addAttribute("listNewestProduct", listNewestProduct);
        model.addAttribute("minPrice", minPrice);
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
        // đưa vào service
        RoleEntity roleE = new RoleEntity();
        roleE.setRole(Role.ROLE_USER);
        Set<RoleEntity> userRoles = new HashSet<>();
        userRoles.add(roleE);
        user.setStatus(UserStatus.ACTIVE);
        user.setUserRoles(userRoles);
        String errMsg = "";

        if (!user.getPassword()
                .isEmpty() || user.getPassword().equals(user.getConfirmPassword())) {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);
            // add ngày khoi tao
            accountRepo.save(user);
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

    @RequestMapping(value = "/checkout")
    public String checkout() {
        return "user/page-checkout";
    }

    @RequestMapping(value = "/cart")
    public String cart() {
        return "user/page-cart";
    }

    @RequestMapping("/403")
    public String accessDenied(Model model) {
        return "403Page";
    }

    private String doUpload(HttpServletRequest request, Model model, Image image) {
        String description = image.getDescription();
        String uploadRootPath = request.getServletContext().getRealPath("/image");
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
        model.addAttribute("description", description);
        model.addAttribute("uploadedFiles", uploadedFiles);
        return "multipart/viewFile";
    }
}
