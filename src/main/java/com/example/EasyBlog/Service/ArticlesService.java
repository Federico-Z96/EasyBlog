package com.example.EasyBlog.Service;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticlesService {
    @Autowired
    private static ArticlesRepository articlesRepository;

    public Articles getArticlesById(Long id) throws Exception {
        Optional<Articles> articlesOptional = articlesRepository.findById(id);
        if (articlesOptional.isEmpty()) {
            throw new IllegalArgumentException("Article does not exist");
        }
        Articles article = articlesOptional.get();
        if (article.getTypeStatus() != TypeStatusEnum.ACTIVE) {
            throw new IllegalArgumentException("Article is not in an active status");
        }
        return article;
    }

    public List<Articles> getAllArticles(){
        List<Articles> activeArticles = new ArrayList<>();
        List<Articles> allArticles = articlesRepository.findAll();
        for (Articles articles : allArticles){
            if (articles.getTypeStatus() == TypeStatusEnum.ACTIVE){
                activeArticles.add(articles);
            }
        }
        return activeArticles;
    }
    public List<Articles> getAllDeletedArticles(){
        List<Articles> inactiveArticles = new ArrayList<>();
        List<Articles> allArticles = articlesRepository.findAll();
        for (Articles articles : allArticles){
            if (articles.getTypeStatus() == TypeStatusEnum.INACTIVE){
                inactiveArticles.add(articles);
            }
        }
        return inactiveArticles;
    }

    public List<Articles> getAllSuspendedArticles(){
        List<Articles> suspendedArticles = new ArrayList<>();
        List<Articles> allArticles = articlesRepository.findAll();
        for (Articles articles : allArticles){
            if (articles.getTypeStatus() == TypeStatusEnum.INACTIVE){
                suspendedArticles.add(articles);
            }
        }
        return suspendedArticles;
    }
}
