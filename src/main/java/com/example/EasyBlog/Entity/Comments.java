package com.example.EasyBlog.Entity;

import jakarta.persistence.*;


import java.util.Date;


@Entity
@Table
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,name = "created_at")
    private String commentText;
    @Column(nullable = false, name = "comment_date")
    private Date commentDate;
    @Column(nullable = false, name = "created_at")
    private Date createdAt;
    @Column(nullable = false, name = "updated_at")
    private Date updatedAt;
    @Column(nullable = false, name = "deleted")
    private boolean deleted;
    @ManyToOne
    private Users users;
    @ManyToOne
    private Articles articles;

    public Comments() {
    }

    public Comments(Long id, String commentText, Date commentDate, Date createdAt, Date updatedAt, boolean deleted, Users users, Articles articles) {
        this.id = id;
        this.commentText = commentText;
        this.commentDate = commentDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deleted = deleted;
        this.users = users;
        this.articles = articles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
