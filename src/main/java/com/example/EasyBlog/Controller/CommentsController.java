package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @PostMapping("/create")
    public Comments createUser(@RequestBody Comments comments, String email, String title){
        return commentsService.createComments(comments, email, title);
    }

    @GetMapping("/getAllActive")
    public Optional<List<Comments>> getAllActiveComments(){return commentsService.getAllActiveComments();}

    @GetMapping("/getAllInactive")
    public Optional<List<Comments>> getAllInactiveComments(){return commentsService.getAllInactiveComments();}
    @GetMapping("/getAllSuspended")
    public Optional<List<Comments>> getAllSuspendedComments(){return commentsService.getAllSuspendedComments();}


}
