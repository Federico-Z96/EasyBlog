package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Enum.TypeGenderArticlesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArticlesRepository extends JpaRepository<Articles,Long> {

    @Query("UPDATE Articles SET type_status = ? WHERE id = ? ")
    Optional<Articles> updateArticlesStatus(Long articleId);

    @Query("SELECT a FROM Articles a WHERE a.type_gender = ?1")
    Optional<List<Articles>> getArticlesByGender(TypeGenderArticlesEnum typeGenderArticlesEnum);

    @Query("SELECT a FROM Articles a WHERE a.title = ?1")
    Optional<Articles> findArticlesByTitle (String title);
    @Query("SELECT a FROM Articles a WHERE a.type_status='ACTIVE'")
    Optional<List<Articles>>findArticlesByActive();

    @Query("SELECT a FROM Articles a WHERE a.type_status='INACTIVE'")
    Optional<List<Articles>>findArticlesByInactive();

    @Query("SELECT a FROM Articles a WHERE a.type_status='SUSPENDED'")
    Optional<List<Articles>>findArticlesBySuspended();
}
