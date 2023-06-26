package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Long> {
    @Query("SELECT c FROM Comments c WHERE c.typeStatus='active'")
    Optional<List<Comments>> findCommentsByActive();

    @Query("SELECT c FROM Comments c WHERE c.typeStatus='inactive'")
    Optional<List<Comments>>findCommentsByInactive();

    @Query("SELECT c FROM Comments c WHERE c.typeStatus='Suspended'")
    Optional<List<Comments>>findCommentsBySuspended();

}
