package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Roles;
import com.example.EasyBlog.Entity.TypeStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArticlesRepository extends JpaRepository<Articles,Long> {
    @Query("SELECT a FROM articles a WHERE a.typeStatus='ACTIVE'")
    Optional<Articles>findByActive(TypeStatusEnum typeStatus);

    // TODO filtrare solo quelli attivi
}
