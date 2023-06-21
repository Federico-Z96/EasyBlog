package com.example.EasyBlog.Service;


import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Repositories.ArticlesRepository;
import com.example.EasyBlog.Repositories.CommentsRepository;
import com.example.EasyBlog.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {
    @Autowired
    private static CommentsRepository commentsRepository;
    @Autowired
    private static UsersRepository usersRepository;
    @Autowired
    private static ArticlesRepository articlesRepository;


    public ResponseEntity<String> createComments(Comments comments, Long id) {
        Optional<Users> findUsers = usersRepository.findById(id);
        Optional<Articles> findArticles = articlesRepository.findById(id);
        if (findUsers.isEmpty() || findArticles.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found or articles not found");
        }
        commentsRepository.save(comments);
        return ResponseEntity.ok("Comment created successfully");
    }

    public ResponseEntity<String> updateComments(Comments comments, Long id) {
        Optional<Comments> updateComments = commentsRepository.findById(id);
        if (updateComments.isEmpty()){
            return ResponseEntity.badRequest().body("Comments not found");
        }
            commentsRepository.save(comments);
            return ResponseEntity.ok("Comment modified");
    }

    public Optional<List<Comments>> getAllActiveComments(){
        return commentsRepository.findCommentsByActive();
    }

    public Optional<List<Comments>> getAllInactiveComments(){
        return commentsRepository.findCommentsByInactive();
    }

    public Optional<List<Comments>> getAllSuspendedComments(){
        return commentsRepository.findCommentsBySuspended();
    }
}