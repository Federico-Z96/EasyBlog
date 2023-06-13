package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Service.ArticlesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Articles")
public class ArticlesController {

    private ArticlesService articlesService;
}