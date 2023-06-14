package com.example.EasyBlog.Entity;

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
    @Column(nullable = false, name = "date_publication")
    private Date datePublication;
    @Column(nullable = false, name = "type_status")
    private TypeStatusEnum typeStatus;
    @ManyToOne
    @JoinColumn(name = "id_author", referencedColumnName = "id")
    private Users users;

    public Articles(Long id, String title, Date createdAt, Date updatedAt, String content, Date datePublication, Users users, TypeStatusEnum typeStatus) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.content = content;
        this.datePublication = datePublication;
        this.users = users;
        this.typeStatus = typeStatus;
    }

    public Articles() {
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

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
