package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Service.CommentsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @Operation(summary = "Create comments from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comment posted",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Comments.class)) }),
            @ApiResponse(responseCode = "404", description = "Article not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Title", content = @Content)
    })


    @PostMapping("/create/{idUser}/{idArticle}")
    public ResponseEntity<String> createComments(@RequestBody Comments comments,@PathVariable Long idArticle,@PathVariable Long idUser) {
        return commentsService.createComments(comments,idArticle,idUser);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <?> updateComments(@RequestBody Comments comments,@PathVariable Long id){
        ResponseEntity<String> updatedComments = commentsService.updateComments(comments,id);
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
