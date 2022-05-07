package com.an.spring_security_blog.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppRole implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public AppRole() {
    }

    public AppRole(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getAuthority() { // tất cả đối tượng thuộc class sẽ instance thuộc GrantedAuthority
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
