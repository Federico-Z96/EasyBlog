package com.example.EasyBlog.Service;

import com.example.EasyBlog.Entity.Likes;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Repositories.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesService {
    @Autowired
    private static LikesRepository likesRepository;

    public List<Likes> getAllLikes(){
        return likesRepository.findAll();
    }
}