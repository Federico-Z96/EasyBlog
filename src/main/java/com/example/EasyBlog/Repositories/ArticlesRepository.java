package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import com.example.EasyBlog.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArticlesRepository extends JpaRepository<Articles,Long> {

    @Query("SELECT a FROM articles a WHERE a.title = ?1")
    Optional<Articles> findArticlesByTitle (String title);
    @Query("SELECT a FROM articles a WHERE a.typeStatus='ACTIVE'")
    Optional<List<Articles>>findByActive();

    @Query("SELECT a FROM articles a WHERE a.typeStatus='INACTIVE'")
    Optional<List<Articles>>findByInactive();

    @Query("SELECT a FROM articles a WHERE a.typeStatus='SUSPENDED'")
    Optional<List<Articles>>findBySuspended();

    // TODO filtrare solo quelli attivi
}
