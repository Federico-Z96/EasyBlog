package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.Likes;
import com.example.EasyBlog.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes,Long> {
}
