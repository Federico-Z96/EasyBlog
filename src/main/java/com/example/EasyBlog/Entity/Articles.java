package com.example.EasyBlog.Entity;

import com.example.EasyBlog.Entity.Enum.TypeGenderArticlesEnum;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import jakarta.persistence.*;


import java.util.Date;


@Entity
@Table
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "title")
    private String title;
    @Column(nullable = false, name = "created_at")
    private Date createdAt;
    @Column(nullable = false, name = "updated_at")
    private Date updatedAt;
    @Column(nullable = false, name = "content")
    private String content;
    @Column(nullable = false, name = "type_status")
    private TypeStatusEnum typeStatus;

    @Column(nullable = false, name = "type_gender")
    private TypeGenderArticlesEnum typeGender;

    @ManyToOne
    @JoinColumn(name = "id_author", referencedColumnName = "id")
    private Users users;

    public Articles(Long id, String title, Date createdAt, Date updatedAt, String content, Users users, TypeStatusEnum typeStatus, TypeGenderArticlesEnum typeGender) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.content = content;
        this.users = users;
        this.typeStatus = typeStatus;
        this.typeGender = typeGender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public TypeStatusEnum getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(TypeStatusEnum typeStatus) {
        this.typeStatus = typeStatus;
    }

    public TypeGenderArticlesEnum getTypeGender() {
        return typeGender;
    }

    public void setTypeGender(TypeGenderArticlesEnum typeGender) {
        this.typeGender = typeGender;
    }
}

