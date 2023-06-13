package com.example.EasyBlog.Service;


import com.example.EasyBlog.Repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {
    @Autowired
    private static CommentsRepository commentsRepository;
}