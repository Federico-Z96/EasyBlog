package com.example.EasyBlog.Service;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import com.example.EasyBlog.Entity.Likes;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Repositories.ArticlesRepository;
import com.example.EasyBlog.Repositories.CommentsRepository;
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
    private UsersRepository usersRepository;
    @Autowired
    private ArticlesRepository articlesRepository;
    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private LikesRepository likesRepository;

    public ResponseEntity<String> createLikeOnArticle(Likes likes, Long idArticle, Long idUser) {
        Users users = usersRepository.findById(idUser).get();
        Articles articles = articlesRepository.findById(idArticle).get();
        if (users.getId() == null || articles.getId() == null) {
            return ResponseEntity.badRequest().body("User not found or articles not found");
        }
        likes.setUsers(users);
        likes.setArticles(articles);
        likesRepository.save(likes);
        return ResponseEntity.ok("Like created successfully");
    }

    public ResponseEntity<String> createLikeOnComment(Likes likes, Long idComment, Long idUser) {
        Users users = usersRepository.findById(idUser).get();
        Comments comments = commentsRepository.findById(idComment).get();
        if (users.getId() == null || comments.getId() == null) {
            return ResponseEntity.badRequest().body("User not found or articles not found");
        }
        likes.setUsers(users);
        likes.setComments(comments);
        likesRepository.save(likes);
        return ResponseEntity.ok("Comment created successfully");
    }

    public Likes getLikeById(Long id) throws Exception {
        Optional<Likes> likeOptional = likesRepository.findById(id);
        if (likeOptional.isEmpty()) {
            return null;
        }
        return likeOptional.get();
    }

    public Optional<List<Likes>> getLikesByStatus(TypeStatusEnum typeStatusEnum) {
        return likesRepository.findLikesByStatus(typeStatusEnum);
    }


    public Likes updateLike(Likes updatedLike) {
        return likesRepository.save(updatedLike);
    }

    public List<Likes> getAllLikes(){
        return likesRepository.findAll();
    }
}