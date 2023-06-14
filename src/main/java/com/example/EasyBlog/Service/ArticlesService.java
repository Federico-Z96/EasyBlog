package com.example.EasyBlog.Service;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticlesService {
    @Autowired
    private static ArticlesRepository articlesRepository;

    public Articles createArticles(Articles articles) {
        Optional<Articles> articleByTitle = articlesRepository.findArticlesByTitle(articles.getTitle());
        if (articleByTitle.isPresent()){
            throw new IllegalStateException("Title already exists");
        }
        return articlesRepository.save(articles);
    }

    public Articles getArticlesById(Long id) throws Exception {
        Optional<Articles> articlesOptional = articlesRepository.findById(id);
        if (articlesOptional.isEmpty()) {
            throw new IllegalArgumentException("Article does not exist");
        }
        Articles article = articlesOptional.get();
        if (article.getTypeStatus() == TypeStatusEnum.INACTIVE) {
            throw new IllegalArgumentException("Article is inactive");
        } else if (article.getTypeStatus() == TypeStatusEnum.SUSPENDED) {
            throw new IllegalArgumentException("Article is suspended");
        } else if (article.getTypeStatus() == TypeStatusEnum.ACTIVE) {
            return article;
        } else {
            throw new IllegalArgumentException("Article is in an unrecognized status");
        }
    }

    public Optional<List<Articles>> getAllArticles(){
        Optional<List<Articles>> activeArticles = articlesRepository.findByActive();
        return activeArticles;
    }

    public Optional<List<Articles>> getAllInactiveArticles(){
        Optional<List<Articles>> inactiveArticles = articlesRepository.findByInactive();
        return inactiveArticles;
    }

    public Optional<List<Articles>> getAllSuspendedArticles(){
        Optional<List<Articles>> suspendedArticles = articlesRepository.findBySuspended();
        return suspendedArticles;
    }



//    public List<Articles> getAllDeletedArticles(){
//        List<Articles> inactiveArticles = new ArrayList<>();
//        List<Articles> allArticles = articlesRepository.findAll();
//        for (Articles articles : allArticles){
//            if (articles.getTypeStatus() == TypeStatusEnum.INACTIVE){
//                inactiveArticles.add(articles);
//            }
//        }
//        return inactiveArticles;
//    }
//
//    public List<Articles> getAllSuspendedArticles(){
//        List<Articles> suspendedArticles = new ArrayList<>();
//        List<Articles> allArticles = articlesRepository.findAll();
//        for (Articles articles : allArticles){
//            if (articles.getTypeStatus() == TypeStatusEnum.INACTIVE){
//                suspendedArticles.add(articles);
//            }
//        }
//        return suspendedArticles;
//    }
}
