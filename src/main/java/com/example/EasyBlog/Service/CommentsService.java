package com.example.EasyBlog.Service;


import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Repositories.ArticlesRepository;
import com.example.EasyBlog.Repositories.CommentsRepository;
import com.example.EasyBlog.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    public Comments createComments(Comments comments) {
        return commentsRepository.save(comments);
    }
    public Comments updateComments(Comments comments, Long id) {
        Optional<Comments> updateComments = commentsRepository.findById(id);
        if (updateComments.isEmpty()){
            ResponseEntity.badRequest().body("Comments not found");
        }
            return commentsRepository.save(comments);
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