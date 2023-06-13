package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Repositories.ArticlesReadRepository;
import com.example.EasyBlog.Service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ArticlesRead")
public class ArticlesReadController {
    @Autowired
    private ArticlesReadRepository articlesReadRepository;
}
