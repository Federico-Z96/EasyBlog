package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @PostMapping("/create")
    public ResponseEntity <Comments> createComments(@RequestBody Comments comments){
        return ResponseEntity.ok(commentsService.createComments(comments));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity <?> updateComments(@RequestBody Comments comments,@PathVariable Long id){
        Comments updatedComments = commentsService.updateComments(comments,id);
        if (updatedComments != null){
            return ResponseEntity.ok(updatedComments);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }
    @GetMapping("/getAllActive")
    public Optional<List<Comments>> getAllActiveComments(){return commentsService.getAllActiveComments();}

    @GetMapping("/getAllInactive")
    public Optional<List<Comments>> getAllInactiveComments(){return commentsService.getAllInactiveComments();}
    @GetMapping("/getAllSuspended")
    public Optional<List<Comments>> getAllSuspendedComments(){return commentsService.getAllSuspendedComments();}


}
