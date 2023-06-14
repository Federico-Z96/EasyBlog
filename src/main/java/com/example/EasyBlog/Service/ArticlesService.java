package com.example.EasyBlog.Service;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.TypeStatusEnum;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.Optional;
import java.util.PrimitiveIterator;
@Service
public class ArticlesService {
    @Autowired
    private static ArticlesRepository articlesRepository;

    public Articles getArticles(Long id, TypeStatusEnum typeStatus) throws Exception {
        Optional<Articles> articlesOptional = articlesRepository.findById(id);
        Optional<Articles> articlesOpt2 = articlesRepository.findByActive(typeStatus);
        if (articlesOpt2.isPresent() || articlesOptional.isEmpty()) throw new IllegalArgumentException("Articles does not exist");
        return articlesOptional.get();
    }
}
