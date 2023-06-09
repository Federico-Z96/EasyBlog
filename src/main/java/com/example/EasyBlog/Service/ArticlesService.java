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
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArticlesService {
    @Autowired
    private ArticlesRepository articlesRepository;
    @Autowired
    private  UsersRepository usersRepository;

    public ResponseEntity<String> createArticles(Articles articles, Long idUser) {
        Users users = usersRepository.findById(idUser).get();
        Optional<Articles> articleByTitle = articlesRepository.findArticlesByTitle(articles.getTitle());
        if (users.getRoles() == TypeRoleEnum.READER || articleByTitle.isPresent()){
          return ResponseEntity.badRequest().body("Title already exists or you haven't permission to create it");
        }
        articles.setUsers(users);
        articlesRepository.save(articles);
        return ResponseEntity.ok().body("Article created");
    }

    public Articles getArticlesById(Long id) throws Exception {
        Optional<Articles> articlesOptional = articlesRepository.findById(id);
        if (articlesOptional.isEmpty()) {
            return null;
        }
        return articlesOptional.get();
    }

    public List<Articles> getAllArticles(){
        return articlesRepository.findAll();
    }

    public Optional<List<Articles>> getStatusArticles(TypeStatusEnum typeStatusEnum) {
        return articlesRepository.findArticlesByActive(typeStatusEnum);
    }

    public Optional<Articles> getArticlesByTitle(String title){return articlesRepository.findArticlesByTitle(title);}

   public Optional <List<Articles>> getArticlesByGender(TypeGenderArticlesEnum typeGenderArticlesEnum){
        return articlesRepository.getArticlesByGender(typeGenderArticlesEnum);}

    public Optional<Articles> updateArticleStatus(Long articleId){
        return articlesRepository.updateArticlesStatus(articleId);
    }

    public Optional<Articles> updateArticle(Long id, Articles articles){
        Optional<Articles> foundArticle = articlesRepository.findById(id);
        if (foundArticle.isEmpty()){
           return Optional.empty();
        }
        articles.setCreatedAt(foundArticle.get().getCreatedAt());
        articles.setUpdatedAt(LocalDateTime.now());
        articles.setId(foundArticle.get().getId());
        articles.setUsers(foundArticle.get().getUsers());
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
