package com.example.EasyBlog.Service;

import com.example.EasyBlog.Repositories.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesService {
    @Autowired
    private static LikesRepository likesRepository;
}