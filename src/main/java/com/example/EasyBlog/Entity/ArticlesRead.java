package com.example.EasyBlog.Entity;


    import jakarta.persistence.*;

import java.util.Date;

    @Entity
    @Table


    public class ArticlesRead {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private long id;
        @Column(nullable = false)
        private Date createdAt;
        @Column(nullable = false)
        private Date updatedAt;
        @Column(nullable = false)
        private boolean deleted;
        @ManyToOne
        private Users users;
        @ManyToOne
        private Articles articles;

        public ArticlesRead() {
        }

        public ArticlesRead(long id, Date createdAt, Date updatedAt, boolean deleted, Users users, Articles articles) {
            this.id = id;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.deleted = deleted;
            this.users = users;
            this.articles = articles;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
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

