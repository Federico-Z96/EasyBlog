package com.example.EasyBlog.Service;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Likes;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Repositories.ArticlesRepository;
import com.example.EasyBlog.Repositories.LikesRepository;
import com.example.EasyBlog.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikesService {
    @Autowired
    private static UsersRepository usersRepository;
    @Autowired
    private static ArticlesRepository articlesRepository;
    @Autowired
    private static LikesRepository likesRepository;

    public Optional<Likes> getLikeById(Long likeId) {
        return likesRepository.findById(likeId);
    }

    public ResponseEntity<String> createLike(Likes newLike, Long idUser, Long idArticle) {
        Optional<Articles> findArticle = articlesRepository.findById(idArticle);
        Optional<Users> findUser = usersRepository.findById(idUser);

        if (findUser.isEmpty() || findArticle.isEmpty()){
            return ResponseEntity.badRequest().body("Error");
        }
        likesRepository.save(newLike);
        return ResponseEntity.ok("Like created");
    }

    public Likes updateLike(Likes updatedLike) {
        return likesRepository.save(updatedLike);
    }

    public List<Likes> getAllLikes(){
        return likesRepository.findAll();
    }
}