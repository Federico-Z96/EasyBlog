package com.example.EasyBlog.Entity;

import com.example.EasyBlog.Entity.Enum.TypeRoleEnum;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
public class Users {
    @Hidden
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
    private LocalDateTime createdAt;
    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(nullable = false, name = "deleted")
    private boolean deleted;
    @Column(nullable = false, name = "type_status")
    @Enumerated(EnumType.ORDINAL)
    private TypeStatusEnum typeStatus;
    @Column(nullable = false, name = "type_role")
    @Enumerated(EnumType.ORDINAL)
    private TypeRoleEnum roles;

    public Users(){}

    public Users(Long id, String username, String password, String email, LocalDateTime createdAt, LocalDateTime updatedAt, TypeStatusEnum typeStatus, TypeRoleEnum roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public TypeRoleEnum getRoles() {
        return roles;
    }

    public void setRoles(TypeRoleEnum roles) {
        this.roles = roles;
    }

    public TypeStatusEnum getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(TypeStatusEnum typeStatus) {
        this.typeStatus = typeStatus;
    }
}
