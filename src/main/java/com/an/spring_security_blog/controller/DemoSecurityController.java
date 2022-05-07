package com.an.spring_security_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class DemoSecurityController {
    @GetMapping("/user")
    public ModelAndView userPage(){
        return new ModelAndView("user");
    }
    @GetMapping("/admin")
    public ModelAndView adminPage(){
        return new ModelAndView("admin");
    }
    @GetMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("home");
    }

}
