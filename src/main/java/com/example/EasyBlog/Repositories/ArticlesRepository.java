package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Enum.TypeGenderArticlesEnum;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ArticlesRepository extends JpaRepository<Articles,Long> {

    @Query("UPDATE Articles SET typeStatus = :status WHERE id = :articleId ")
    Optional<Articles> updateArticlesStatus(Long articleId);

   @Query("SELECT a FROM Articles a WHERE a.typeGender = :gender")
   Optional<Articles> getArticlesByGender(@Param("gender") TypeGenderArticlesEnum typeGenderArticlesEnum);

    @Query("SELECT a FROM Articles a WHERE a.title =:title ")
    Optional<Articles> findArticlesByTitle (String title);
    @Query("SELECT a FROM Articles a WHERE a.typeStatus=:status")
    Optional<List<Articles>>findArticlesByActive(@Param("status")TypeStatusEnum typeStatusEnum);
}
