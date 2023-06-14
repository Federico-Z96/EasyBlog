package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.ArticlesRead;
import com.example.EasyBlog.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesReadRepository extends JpaRepository<ArticlesRead,Long> {

}
