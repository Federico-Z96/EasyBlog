package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import com.example.EasyBlog.Entity.Likes;
import com.example.EasyBlog.Service.LikesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Likes")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @Operation(summary = "Create like on article from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Like posted",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Comments.class)) }),
            @ApiResponse(responseCode = "404", description = "Article not found or user not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Like", content = @Content)
    })
    @PostMapping("/createLikeOnArticle/{idUser}/{idArticle}")
    public ResponseEntity<String> createLikeOnArticle(@RequestBody Likes likes, @PathVariable Long idUser, @PathVariable Long idArticle) {
        return likesService.createLikeOnArticle(likes,idUser,idArticle);
    }


    @Operation(summary = "Create like on comment from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Like posted",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Comments.class)) }),
            @ApiResponse(responseCode = "404", description = "Comment not found or user not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Like", content = @Content)
    })
    @PostMapping("/createLikeOnComment/{idUser}/{idComment}")
    public ResponseEntity<String> createLikeOnComment(@RequestBody Likes likes, @PathVariable Long idUser, @PathVariable Long idComment) {
        return likesService.createLikeOnArticle(likes,idUser,idComment);
    }

    @Operation(summary = "Get like by id from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Like successfully retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "Like not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Like", content = @Content)
    })
    @GetMapping("/getLikeById/{idLike}")
    public Likes getLikeById(@PathVariable Long idLike) throws Exception {
        return likesService.getLikeById(idLike);
    }


    @Operation(summary = "Get status like from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Like successfully retrieved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "Like not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid status", content = @Content)
    })
    @GetMapping("/getLikeStatus/{status}")
    public ResponseEntity<?> getLikeStatus(@PathVariable TypeStatusEnum status) {
        Optional<List<Likes>> activeLikeOptional = likesService.getLikesByStatus(status);

        if (activeLikeOptional.isPresent()) {
            List<Likes> likeStatus = activeLikeOptional.get();
            return ResponseEntity.ok(likeStatus);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }
}
