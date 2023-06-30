package com.example.EasyBlog.Service;

import com.example.EasyBlog.Entity.Enum.TypeRoleEnum;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class UsersService {
   @Autowired
    private UsersRepository usersRepository;
   public UsersService(UsersRepository usersRepository) {
       this.usersRepository = usersRepository;
   }

    public ResponseEntity<String> createUser(Users users){
        Optional<Users> userByEmail = usersRepository.findUserByEmail(users.getEmail());
        if (userByEmail.isPresent()){
           return ResponseEntity.badRequest().body("Already register");
        }
        usersRepository.save(users);
        return ResponseEntity.ok().body("User register");
    }

    public Users getUserById(Long idUser){
        Optional<Users> usersOptional = usersRepository.findById(idUser);
        if (usersOptional.isEmpty()) {
           return null;
        }
        return usersOptional.get();
    }

    public Users getUserByEmail(String email){
        Optional<Users> usersOptional = usersRepository.findUserByEmail(email);
        if (usersOptional.isEmpty()) {
            return null;
        }
        return usersOptional.get();
    }

    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public Users updateUser (Users users, Long id){
        Optional<Users> optionalUpdateUser = usersRepository.findById(id);

        if (optionalUpdateUser.isEmpty()) {
            return null;
        } else {
          Users updateUser = optionalUpdateUser.get();
          updateUser.setRoles(users.getRoles());
          updateUser.setTypeStatus(users.getTypeStatus());
          updateUser.setUpdatedAt(LocalDateTime.now());
          updateUser.setEmail(users.getEmail());
          updateUser.setUsername(users.getUsername());
          updateUser.setPassword(users.getPassword());
            return usersRepository.saveAndFlush(updateUser);
        }

    }
    public List<Users> getAllUsersRoles(TypeRoleEnum typeRoleEnum){return usersRepository.findByTypeRole(typeRoleEnum);}

    public List<Users> getAllUsersStatus(TypeStatusEnum typeStatusEnum){return usersRepository.findUsersByStatus(typeStatusEnum);}

    }
