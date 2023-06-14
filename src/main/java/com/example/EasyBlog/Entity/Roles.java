package com.example.EasyBlog.Entity;

import com.example.EasyBlog.Entity.Enum.TypeRoleEnum;
import jakarta.persistence.*;


import java.util.Date;


@Entity
@Table
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "role_name")
    private TypeRoleEnum roleName;
    @Column(nullable = false, name = "created_at")
    private Date createdAt;
    @Column(nullable = false, name = "updated_at")
    private Date updatedAt;

    public Roles() {
    }

    public Roles(Long id, TypeRoleEnum roleName, Date createdAt, Date updatedAt) {
        this.id = id;
        this.roleName = roleName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeRoleEnum getRoleName() {
        return roleName;
    }

    public void setRoleName(TypeRoleEnum roleName) {
        this.roleName = roleName;
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

}
