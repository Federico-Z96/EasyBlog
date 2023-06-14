package com.example.EasyBlog.Entity;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "username")
    private String username;
    @Column(nullable = false,name = "password" )
    private String password;
    @Column(nullable = false, name = "email" )
    private String email;
    @Column(nullable = false, name = "created_at")
    private Date createdAt;
    @Column(nullable = false, name = "updated_at")
    private Date updatedAt;
    @Column(nullable = false, name = "deleted")
    private boolean deleted;
    @Column(nullable = false, name = "type_status")
    private TypeStatusEnum typeStatus;
    @ManyToOne
    private Roles roles;

    public Users() {
    }

    public Users(Long id, String username, String password, String email, Date createdAt, Date updatedAt, boolean deleted, TypeStatusEnum typeStatus, Roles roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deleted = deleted;
        this.typeStatus = typeStatus;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
