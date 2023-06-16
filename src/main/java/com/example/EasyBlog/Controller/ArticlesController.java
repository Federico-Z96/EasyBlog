package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Enum.TypeGenderArticlesEnum;
import com.example.EasyBlog.Entity.Users;
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
    public Articles createArticles(@RequestBody Articles articles, Users users){return articlesService.createArticles(articles,users);}

    @GetMapping("/getArticlesActive/{id}")
    public Articles getArticleById(@PathVariable Long idArticles) throws Exception {return articlesService.getArticlesById(idArticles);}

    @GetMapping("/getArticlesInactive")
    public Optional<List<Articles>> getArticlesInactive() {return articlesService.getAllInactiveArticles();
    }

    @GetMapping("/getArticlesSuspended")
    public Optional<List<Articles>> getArticlesSuspended(){return articlesService.getAllSuspendedArticles();}

    @GetMapping("/getAllArticles")
    public List<Articles> getAllArticles(){return articlesService.getAllArticles();}

    @GetMapping("/getArticlesBy/{title}")
    public Optional<Articles> getArticlesByTitle(@PathVariable String title){return articlesService.getArticlesByTitle(title);}

    @GetMapping("/getArticleByGender/{gender}")
    public Optional<List<Articles>> getArticlesByGender(@PathVariable TypeGenderArticlesEnum typeGenderArticlesEnum){return articlesService.getArticlesByGender(typeGenderArticlesEnum);}

    @PutMapping("/{id}/update")
    public Optional<Articles> updateArticle(@PathVariable Integer id, @RequestBody){return articlesService.updateArticleStatus(id);}


}