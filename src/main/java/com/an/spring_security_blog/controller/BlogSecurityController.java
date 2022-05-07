package com.an.spring_security_blog.controller;

import com.an.spring_security_blog.model.Blog;
import com.an.spring_security_blog.model.Category;
import com.an.spring_security_blog.service.blog.IBlogService;
import com.an.spring_security_blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogSecurityController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @ModelAttribute("categories")
    private Iterable<Category> listCategories(){
        return categoryService.findAll();
    }

    @GetMapping("/blog")
    public ModelAndView listBlog(){
        Iterable<Blog> blogs = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("blog/list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createNewBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog() );
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Blog> blog = blogService.findById(id);
            ModelAndView modelAndView = new ModelAndView("blog/edit");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping ("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/delete");
        modelAndView.addObject("blog", blog.get());
        return modelAndView;
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute("blog") Blog blog){
        blogService.remove(blog.getId());
        return "redirect:blog";
    }



}
