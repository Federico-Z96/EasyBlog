package com.example.EasyBlog.Service;


import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsService {
    @Autowired
    private static CommentsRepository commentsRepository;

    public List<Comments> getAllUsers(){
        return commentsRepository.findAll();
    }

    public List<Comments> getAllActiveComments(){
        List<Comments> activeComments = new ArrayList<>();
        List<Comments> allComments = commentsRepository.findAll();
        for (Comments comments : allComments){
            if (comments.getTypeStatus() == TypeStatusEnum.ACTIVE){
                activeComments.add(comments);
            }
        }
        return activeComments;
    }
}