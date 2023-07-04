package com.example.EasyBlog.Entity;

import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
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
    @Column(nullable = false, name = "type_status")
    @Enumerated(EnumType.ORDINAL)
    private TypeStatusEnum typeStatus;
    @ManyToOne
    private Users users;
    @ManyToOne
    private Articles articles;
    @ManyToOne
    private Comments comments;

    public Likes(){}

    public Likes(Long id, LocalDateTime createdAt, LocalDateTime updatedAt,TypeStatusEnum typeStatusEnum, Users users, Articles articles, Comments comments) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.typeStatus = typeStatusEnum;
        this.users = users;
        this.articles = articles;
        this.comments = comments;
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

    public TypeStatusEnum getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(TypeStatusEnum typeStatus) {
        this.typeStatus = typeStatus;
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

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }
}