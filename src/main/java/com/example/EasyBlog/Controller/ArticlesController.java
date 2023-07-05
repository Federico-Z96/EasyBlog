package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Enum.TypeGenderArticlesEnum;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Service.ArticlesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Create articles from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article successfully retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "Article not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Title", content = @Content)
    })
    @PostMapping("/create/{idUser}")
    public ResponseEntity<String> createArticles(@RequestBody Articles articles,@PathVariable Long idUser) {
        return articlesService.createArticles(articles,idUser);
    }

    @Operation(summary = "Get articles from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article successfully retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "Article not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Title", content = @Content)
    })
    @GetMapping("/getArticlesById/{idArticles}")
    public Articles getArticleById(@PathVariable Long idArticles) throws Exception {
        return articlesService.getArticlesById(idArticles);
    }

    @Operation(summary = "Get status articles from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article successfully retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "Article not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid status", content = @Content)
    })
    @GetMapping("/getArticlesStatus/{status}")
    public ResponseEntity<?> getArticlesActive(@PathVariable TypeStatusEnum status) {
        Optional<List<Articles>> activeArticlesOptional = articlesService.getStatusArticles(status);

        if (activeArticlesOptional.isPresent()) {
            List<Articles> suspendedArticles = activeArticlesOptional.get();
            return ResponseEntity.ok(suspendedArticles);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }
    @Operation(summary = "Get all articles from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article successfully retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "Article not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Title", content = @Content)
    })

    @GetMapping("/getAllArticles")
    public ResponseEntity<?> getAllArticles() {
        List<Articles> allArticles = articlesService.getAllArticles();

        if (!allArticles.isEmpty()) {
            return ResponseEntity.ok(allArticles);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }
    @Operation(summary = "Get articles by title from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article successfully retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "Article not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Title", content = @Content)
    })

    @GetMapping("/getArticles/byTitle/{title}")
    public ResponseEntity<?> getArticlesByTitle(@PathVariable String title) {
        Optional<Articles> articlesOptional = articlesService.getArticlesByTitle(title);

        if (articlesOptional.isPresent()) {
            Articles article = articlesOptional.get();
            return ResponseEntity.ok(article);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @Operation(summary = "Get articles by gender from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article successfully retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "Article not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Title", content = @Content)
    })
    @GetMapping("/getArticleByGender/{gender}")
    public ResponseEntity<?> getArticlesByGender(@PathVariable ("gender") TypeGenderArticlesEnum typeGenderArticlesEnum) {
        Optional <List<Articles>> articlesOptional = articlesService.getArticlesByGender(typeGenderArticlesEnum);

        if (articlesOptional.isPresent()) {
            List<Articles> articlesByGender = articlesOptional.get();
            return ResponseEntity.ok(articlesByGender);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @Operation(summary = "Update from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article successfully retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "Article not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Title", content = @Content)
    })
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