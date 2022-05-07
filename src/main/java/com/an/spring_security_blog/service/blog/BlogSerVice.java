package com.an.spring_security_blog.service.blog;



import com.an.spring_security_blog.model.Blog;
import com.an.spring_security_blog.repo.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BlogSerVice implements IBlogService {
    @Autowired
    private BlogRepo blogRepo;
    @Override
    public Iterable<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepo.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepo.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepo.deleteById(id);

    }
}
