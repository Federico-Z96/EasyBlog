package com.example.EasyBlog.Entity;

import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,name = "comment_body")
    private String commentText;
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;
    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(nullable = false, name = "type_status")
    @Enumerated(EnumType.ORDINAL)
    private TypeStatusEnum typeStatus;

    @Hidden
    @ManyToOne
    @JoinColumn(name = "id_author", referencedColumnName = "id")
    private Users users;
    @Hidden
    @ManyToOne
    @JoinColumn(name = "id_article", referencedColumnName = "id")
    private Articles articles;

    public Comments(){}

    public Comments(Long id, String commentText, LocalDateTime createdAt, LocalDateTime updatedAt, TypeStatusEnum typeStatus, Users users, Articles articles) {
        this.id = id;
        this.commentText = commentText;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.typeStatus = typeStatus;
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

    public TypeStatusEnum getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(TypeStatusEnum typeStatus) {
        this.typeStatus = typeStatus;
    }
}
