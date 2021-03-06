package com.how2java.tmall.com.how2java.tmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController{
    @GetMapping(value="/admin")
    public String admin(){
        return "redirect:admin_category_list";
    }
    @GetMapping(value="/admin_category_list")
    public String listCategory(){
        return "admin/listCategory";
    }
    @GetMapping(value="/admin_category_edit")
    public String editCategory(){
        return "admin/editCategory";

    }
    @GetMapping(value="/admin_property_list")
    public String listProperty(){
        return "admin/listProperty";

    }
    @GetMapping(value="/admin_property_edit")
    public String editProperty(){
        return "admin/editProperty";

    }
}
