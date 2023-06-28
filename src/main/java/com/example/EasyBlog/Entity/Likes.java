package com.example.EasyBlog.Entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;
    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;
    @ManyToOne
    private Users users;
    @ManyToOne
    private Articles articles;

    public Likes(){}

    public Likes(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, Users users, Articles articles) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.users = users;
        this.articles = articles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Articles getArticles() {
        return articles;
    }

    public void setArticles(Articles articles) {
        this.articles = articles;
    }
}