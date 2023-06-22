package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes,Long> {
}
