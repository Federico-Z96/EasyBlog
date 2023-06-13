package com.example.EasyBlog.Service;

import com.example.EasyBlog.Repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.PrimitiveIterator;
@Service
public class ArticlesService {
    @Autowired
    private static ArticlesRepository articlesRepository;
}
