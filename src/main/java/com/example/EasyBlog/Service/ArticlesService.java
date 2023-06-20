package com.example.EasyBlog.Service;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Enum.TypeGenderArticlesEnum;
import com.example.EasyBlog.Entity.Enum.TypeRoleEnum;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Repositories.ArticlesRepository;
import com.example.EasyBlog.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticlesService {
    @Autowired
    private static ArticlesRepository articlesRepository;
    @Autowired
    private static UsersRepository usersRepository;

    public Articles createArticles(Articles articles,Users users) {
        Optional<Articles> articleByTitle = articlesRepository.findArticlesByTitle(articles.getTitle());
        if (users.getRoles() == TypeRoleEnum.READER || articleByTitle.isPresent()){
            ResponseEntity.badRequest().body("Title already exists or you haven't permission to create it");
        }
        return articlesRepository.save(articles);
    }

    public Articles getArticlesById(Long id) throws Exception {
        Optional<Articles> articlesOptional = articlesRepository.findById(id);
        if (articlesOptional.isEmpty()) {
            ResponseEntity.badRequest().body("Article does not exist");
        }
        Articles article = articlesOptional.get();
        if (article.getTypeStatus() == TypeStatusEnum.INACTIVE) {
            ResponseEntity.badRequest().body("Article is inactive");
        } else if (article.getTypeStatus() == TypeStatusEnum.SUSPENDED) {
            ResponseEntity.badRequest().body("Article is suspended");
        } else if (article.getTypeStatus() == TypeStatusEnum.ACTIVE) {
            ResponseEntity.ok(article);
        } else {
            throw new IllegalArgumentException("Article is in an unrecognized status");
        }
        return null;
    }

    public List<Articles> getAllArticles(){
        return articlesRepository.findAll();
    }

    public Optional<List<Articles>> getAllInactiveArticles(){

        return articlesRepository.findArticlesByInactive();
    }

    public Optional<List<Articles>> getAllSuspendedArticles(){
        return articlesRepository.findArticlesBySuspended();
    }

    public Optional<Articles> getArticlesByTitle(String title){return articlesRepository.findArticlesByTitle(title);}

    public Optional<List<Articles>> getArticlesByGender(TypeGenderArticlesEnum typeGenderArticlesEnum){return articlesRepository.getArticlesByGender(typeGenderArticlesEnum);}

    public Optional<Articles> updateArticleStatus(Long articleId){
        return articlesRepository.updateArticlesStatus(articleId);}

    public Optional<Articles> updateArticle(Long id, Articles articles){
        Optional<Articles> foundArticle = articlesRepository.findById(id);

        if (foundArticle.isEmpty()){
           return Optional.empty();
        }
        return Optional.of(articlesRepository.save(articles));

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
