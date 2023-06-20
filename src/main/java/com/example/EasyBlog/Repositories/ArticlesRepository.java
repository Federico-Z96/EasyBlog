package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Enum.TypeGenderArticlesEnum;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import com.example.EasyBlog.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArticlesRepository extends JpaRepository<Articles,Long> {

    @Query("UPDATE Articles SET typeStatus = ? WHERE id = ? ")
    Optional<Articles> updateArticlesStatus(Integer articleId);

    @Query("SELECT a FROM Articles a WHERE a.typeGender = ?1")
    Optional<List<Articles>> getArticlesByGender(TypeGenderArticlesEnum typeGenderArticlesEnum);

    @Query("SELECT a FROM Articles a WHERE a.title = ?1")
    Optional<Articles> findArticlesByTitle (String title);
    @Query("SELECT a FROM Articles a WHERE a.typeStatus='ACTIVE'")
    Optional<List<Articles>>findArticlesByActive();

    @Query("SELECT a FROM Articles a WHERE a.typeStatus='INACTIVE'")
    Optional<List<Articles>>findArticlesByInactive();

    @Query("SELECT a FROM Articles a WHERE a.typeStatus='SUSPENDED'")
    Optional<List<Articles>>findArticlesBySuspended();



    // TODO filtrare solo quelli attivi
}
