package com.example.EasyBlog.Service;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users createUser(Users users){
        Optional<Users> userByEmail = usersRepository.findUserByEmail(users.getEmail());
        if (userByEmail.isPresent()){
            ResponseEntity.badRequest().body("Already register");
        }
       return usersRepository.save(users);
    }

    public Users getUserById(Long idUser){
        Optional<Users> usersOptional = usersRepository.findById(idUser);
        if (usersOptional.isEmpty()) ResponseEntity.badRequest().body("User does not exist");
        return usersOptional.get();
    }

    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public Optional<List<Users>> getAllActiveUsers(){
        return usersRepository.findUsersByActive();
    }

    public Optional<List<Users>> getAllInactiveUsers(){
        return usersRepository.findUsersByInactive();
    }

    public Optional<List<Users>> getAllSuspendedUsers(){
        return usersRepository.findUsersBySuspended();
    }


    public Users updateUser (Users users){return usersRepository.save(users); }

    public Users deleteUser(Long idUser){
        Optional<Users> usersOptional = usersRepository.findById(idUser);
        if (usersOptional.isEmpty()) ResponseEntity.badRequest().body("User does not exist");
        return usersOptional.get();
    }

    public List<Users> deleteAllUsers(){
        List<Users> deletedUsers = new ArrayList<>();
        List<Users> allUsers = usersRepository.findAll();

        for (Users user : allUsers) {
            deletedUsers.add(user);
            usersRepository.delete(user);
        }

        return deletedUsers;
    }

    }
