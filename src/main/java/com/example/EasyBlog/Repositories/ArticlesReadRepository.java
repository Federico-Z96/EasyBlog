package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.ArticlesRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesReadRepository extends JpaRepository<ArticlesRead,Long> {

}
