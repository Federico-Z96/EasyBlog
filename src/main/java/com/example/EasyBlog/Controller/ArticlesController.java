package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Articles")
public class ArticlesController {
    @Autowired
    private ArticlesService articlesService;

    @PostMapping("/create")
    public Articles createArticles(@RequestBody Articles articles){return articlesService.createArticles(articles);}

    @GetMapping("/getArticlesActive/{id}")
    public Articles getArticlesById(@PathVariable Long idArticles) throws Exception {return articlesService.getArticlesById(idArticles);}

    @GetMapping("/getArticlesInactive")
    public Optional<List<Articles>> getArticlesInactive() {return articlesService.getAllInactiveArticles();
    }

    @GetMapping("/getArticlesSuspended")
    public Optional<List<Articles>> getArticlesSuspended(){return articlesService.getAllSuspendedArticles();}

    @GetMapping("/getAllArticles")
    public Optional<List<Articles>> getAllArticles(){return articlesService.getAllArticles();}

    @GetMapping("/getArticlesBy/{title}")
    public Optional<Articles> getArticlesByTitle(@PathVariable String title){return articlesService.getArticlesByTitle(title);}


}