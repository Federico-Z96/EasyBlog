package com.example.EasyBlog.Entity;

import jakarta.persistence.*;


import java.util.Date;


@Entity
@Table
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "like_date")
    private Date likeDate;
    @Column(nullable = false, name = "created_at")
    private Date createdAt;
    @Column(nullable = false, name = "updated_at")
    private Date updatedAt;
    @ManyToOne
    private Users users;
    @ManyToOne
    private Articles articles;

    public Likes() {
    }

    public Likes(Long id, Date likeDate, Date createdAt, Date updatedAt, Users users, Articles articles) {
        this.id = id;
        this.likeDate = likeDate;
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

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
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