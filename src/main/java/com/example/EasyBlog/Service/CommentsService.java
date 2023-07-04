package com.example.EasyBlog.Service;


import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Repositories.ArticlesRepository;
import com.example.EasyBlog.Repositories.CommentsRepository;
import com.example.EasyBlog.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {
    @Autowired
    private  CommentsRepository commentsRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ArticlesRepository articlesRepository;


    public ResponseEntity<String> createComments(Comments comments,Long idArticle, Long idUser) {
        Users users = usersRepository.findById(idUser).get();
        Articles articles = articlesRepository.findById(idArticle).get();
        if (users.getId() == null || articles.getId() == null) {
            return ResponseEntity.badRequest().body("User not found or articles not found");
        }
        comments.setUsers(users);
        comments.setArticles(articles);
        commentsRepository.save(comments);
        return ResponseEntity.ok("Comment created successfully");
    }

    public Optional<Comments> updateComment(Long id, Comments comments){
        Optional<Comments> foundComment = commentsRepository.findById(id);
        if (foundComment.isEmpty()){
            return Optional.empty();
        }
        comments.setCreatedAt(foundComment.get().getCreatedAt());
        comments.setUpdatedAt(LocalDateTime.now());
        comments.setId(foundComment.get().getId());
        comments.setUsers(foundComment.get().getUsers());
        return Optional.of(commentsRepository.save(comments));
    }

    public Comments getCommentById(Long id) throws Exception {
        Optional<Comments> commentOptional = commentsRepository.findById(id);
        if (commentOptional.isEmpty()) {
            return null;
        }
        return commentOptional.get();
    }

    public Optional<List<Comments>> getCommentsByStatus(TypeStatusEnum typeStatusEnum) {
        return commentsRepository.findCommentByStatus(typeStatusEnum);
    }
}