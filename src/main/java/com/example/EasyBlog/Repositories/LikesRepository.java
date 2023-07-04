package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import com.example.EasyBlog.Entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikesRepository extends JpaRepository<Likes,Long> {
    @Query("SELECT l FROM Likes l WHERE l.typeStatus=:status")
    Optional<List<Likes>> findLikesByStatus(@Param("status") TypeStatusEnum typeStatusEnum);
}
