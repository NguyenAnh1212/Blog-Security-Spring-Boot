package com.an.spring_security_blog.repo;


import com.an.spring_security_blog.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends PagingAndSortingRepository<Blog, Long> {

}
