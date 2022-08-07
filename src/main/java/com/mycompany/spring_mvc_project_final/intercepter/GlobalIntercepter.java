/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.intercepter;

import com.mycompany.spring_mvc_project_final.entities.Category;
import com.mycompany.spring_mvc_project_final.service.CategoryService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class GlobalIntercepter extends HandlerInterceptorAdapter {

    @Autowired
    private CategoryService cateService;
  
    @Override
    public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,
            ModelAndView modelAndView) throws Exception {
        List<Category> cates = cateService.getCategories();
        modelAndView.addObject("cates", cates);
        
    }

}
