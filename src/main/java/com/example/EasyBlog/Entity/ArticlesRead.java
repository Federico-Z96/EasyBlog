package com.example.EasyBlog.Entity;


    import jakarta.persistence.*;

import java.util.Date;

    @Entity
    @Table


    public class ArticlesRead {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;
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

        public ArticlesRead(Long id, Date createdAt, Date updatedAt, Users users, Articles articles) {
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

