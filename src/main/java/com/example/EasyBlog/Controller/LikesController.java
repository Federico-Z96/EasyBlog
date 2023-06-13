package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Likes")
public class LikesController {
    @Autowired
    private LikesService likesService;
}
