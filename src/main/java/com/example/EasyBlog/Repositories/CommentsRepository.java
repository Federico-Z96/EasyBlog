package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Long> {
    @Query("SELECT c FROM Comments c WHERE c.typeStatus=:status")
    Optional<List<Comments>>findCommentByStatus(@Param("status") TypeStatusEnum typeStatusEnum);
    @Query("SELECT c FROM Comments c WHERE c.typeStatus=0")
    Optional<List<Comments>> findCommentsByActive();

    @Query("SELECT c FROM Comments c WHERE c.typeStatus=1")
    Optional<List<Comments>>findCommentsByInactive();

    @Query("SELECT c FROM Comments c WHERE c.typeStatus=2")
    Optional<List<Comments>>findCommentsBySuspended();

}
