package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.Category;
import com.mycompany.spring_mvc_project_final.entities.Product;
import com.mycompany.spring_mvc_project_final.service.CategoryService;
import com.mycompany.spring_mvc_project_final.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @Autowired
    CategoryService cateService;
    

    @RequestMapping(value = "/product/list-by-category/{categoryId}")
    public String viewProductByCategory(Model model, @PathVariable("categoryId") Long categoryId) {
        Category cate = cateService.getCategoryById(categoryId);
        List<Product> products = productService.getProductsByCategory(cate);
        model.addAttribute("products", products);
        return "user/page-product-by-category";
    }



}
