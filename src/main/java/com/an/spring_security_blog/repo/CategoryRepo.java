package com.an.spring_security_blog.repo;


import com.an.spring_security_blog.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends PagingAndSortingRepository<Category, Long> {
}
