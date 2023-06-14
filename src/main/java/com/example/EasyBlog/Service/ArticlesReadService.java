package com.example.EasyBlog.Service;

import com.example.EasyBlog.Entity.ArticlesRead;
import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Repositories.ArticlesReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesReadService {
    @Autowired
    private static ArticlesReadRepository articlesReadRepository;

    public List<ArticlesRead> getAllArticlesRead(){
        return articlesReadRepository.findAll();
    }
}