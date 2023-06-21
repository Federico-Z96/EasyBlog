package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Entity.Likes;
import com.example.EasyBlog.Service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Likes")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping("/create")
    public ResponseEntity<String> createLike(@RequestBody Likes likes, Long idUser, Long idArticle) {
        return likesService.createLike(likes, idArticle, idUser);
    }
}
