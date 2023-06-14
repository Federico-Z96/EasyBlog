package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommentsRepository extends JpaRepository<Comments,Long> {
    @Query("SELECT c FROM comments c WHERE c.typeStatus='ACTIVE'")
    Optional<List<Comments>> findCommentsByActive();

    @Query("SELECT c FROM comments c WHERE c.typeStatus='INACTIVE'")
    Optional<List<Comments>>findCommentsByInactive();

    @Query("SELECT c FROM comments c WHERE c.typeStatus='SUSPENDED'")
    Optional<List<Comments>>findCommentsBySuspended();

}
