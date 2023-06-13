package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;
}
