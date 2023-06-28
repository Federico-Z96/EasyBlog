package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Enum.TypeGenderArticlesEnum;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Articles")
public class ArticlesController {
    @Autowired
    private ArticlesService articlesService;

    @PostMapping("/create")
    public ResponseEntity<String> createArticles(@RequestBody Articles articles, Users users) {
        return articlesService.createArticles(articles,users);
    }

    @GetMapping("/getArticlesActive/{id}")
    public Articles getArticleById(@PathVariable Long idArticles) throws Exception {
        return articlesService.getArticlesById(idArticles);
//        try{
//            return ResponseEntity.ok(articlesService.getArticlesById(idArticles));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Invalid arguments");
//        }
    }

    @GetMapping("/getArticlesInactive")
    public ResponseEntity<?> getArticlesInactive() {
        Optional<List<Articles>> inactiveArticlesOptional = articlesService.getAllInactiveArticles();

        if (inactiveArticlesOptional.isPresent()) {
            List<Articles> inactiveArticles = inactiveArticlesOptional.get();
            return ResponseEntity.ok(inactiveArticles);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @GetMapping("/getArticlesSuspended")
    public ResponseEntity<?> getArticlesSuspended() {
        Optional<List<Articles>> suspendedArticlesOptional = articlesService.getAllSuspendedArticles();

        if (suspendedArticlesOptional.isPresent()) {
            List<Articles> suspendedArticles = suspendedArticlesOptional.get();
            return ResponseEntity.ok(suspendedArticles);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @GetMapping("/getAllArticles")
    public ResponseEntity<?> getAllArticles() {
        List<Articles> allArticles = articlesService.getAllArticles();

        if (!allArticles.isEmpty()) {
            return ResponseEntity.ok(allArticles);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @GetMapping("/getArticlesBy/{title}")
    public ResponseEntity<?> getArticlesByTitle(@PathVariable String title) {
        Optional<Articles> articlesOptional = articlesService.getArticlesByTitle(title);

        if (articlesOptional.isPresent()) {
            Articles article = articlesOptional.get();
            return ResponseEntity.ok(article);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @GetMapping("/getArticleByGender/{gender}")
    public ResponseEntity<?> getArticlesByGender(@PathVariable TypeGenderArticlesEnum typeGenderArticlesEnum) {
        Optional<Articles> articlesOptional = articlesService.getArticlesByGender(typeGenderArticlesEnum);

        if (articlesOptional.isPresent()) {
            Articles articlesByGender = articlesOptional.get();
            return ResponseEntity.ok(articlesByGender);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateArticle(@PathVariable Long id, @RequestBody Articles articles) {
        Optional<Articles> updatedArticle = articlesService.updateArticle(id, articles);

        if (updatedArticle.isPresent()) {
            return ResponseEntity.ok(updatedArticle.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }


}