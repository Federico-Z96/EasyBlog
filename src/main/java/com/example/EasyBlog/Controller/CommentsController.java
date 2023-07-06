package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
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
    @Operation(summary = "Update comments from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comment posted",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Comments.class)) }),
            @ApiResponse(responseCode = "404", description = "Comment not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Comment", content = @Content)
    })

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateComment(@PathVariable Long id, @RequestBody Comments comment) {
        Optional<Comments> updatedComment = commentsService.updateComment(id, comment);

        if (updatedComment.isPresent()) {
            return ResponseEntity.ok(updatedComment.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @Operation(summary = "Get status comments from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comment successfully retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "Comment not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid status", content = @Content)
    })
    @GetMapping("/getCommentsStatus/{status}")
    public ResponseEntity<?> getCommentStatus(@PathVariable TypeStatusEnum status) {
        Optional<List<Comments>> activeCommentsOptional = commentsService.getCommentsByStatus(status);

        if (activeCommentsOptional.isPresent()) {
            List<Comments> commentStatus = activeCommentsOptional.get();
            return ResponseEntity.ok(commentStatus);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @Operation(summary = "Get comment by id from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comment successfully retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "Comment not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Comment", content = @Content)
    })
    @GetMapping("/getCommentById/{idComment}")
    public Comments getCommentById(@PathVariable Long idComment) throws Exception {
        return commentsService.getCommentById(idComment);
    }



}
