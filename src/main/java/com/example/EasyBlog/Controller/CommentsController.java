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
    public ResponseEntity <?> getAllActiveComments() {
        Optional<List<Comments>> activeComments = commentsService.getAllActiveComments();

        if (activeComments.isPresent()) {
            return ResponseEntity.ok(activeComments.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
    }
    @GetMapping("/getAllInactive")
    public ResponseEntity<?> getAllInactiveComments() {
        Optional <List<Comments>> inactiveComments = commentsService.getAllInactiveComments();
        if (inactiveComments.isPresent()) {
            return ResponseEntity.ok(inactiveComments.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
    }

    @GetMapping("/getAllSuspended")
    public ResponseEntity<?> getAllSuspendedComments() {
        Optional<List<Comments>> getAllSuspendedComments = commentsService.getAllSuspendedComments();
        if (getAllSuspendedComments.isPresent()){
            return ResponseEntity.ok(getAllSuspendedComments.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
    }



}
