package com.example.EasyBlog.Service;

import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public ResponseEntity<String> getUserById(Long idUser){
        Optional<Users> usersOptional = usersRepository.findById(idUser);
        if (usersOptional.isEmpty()) {
           return ResponseEntity.badRequest().body("User does not exist");
        }
        usersOptional.get();
        return ResponseEntity.ok().body("id found");
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


    public Users updateUser (Users users, Long id){
        Optional<Users> updateUser = usersRepository.findById(id);

        if (updateUser.isEmpty()) {
            return null;
        } else {
            return usersRepository.save(users);
        }

    }
//
//    public Users deleteUser(Long idUser){
//        Optional<Users> usersOptional = usersRepository.findById(idUser);
//        if (usersOptional.isEmpty()) ResponseEntity.badRequest().body("User does not exist");
//        return usersOptional.get();
//    }
//
//    public List<Users> deleteAllUsers(){
//        List<Users> deletedUsers = new ArrayList<>();
//        List<Users> allUsers = usersRepository.findAll();
//
//        for (Users user : allUsers) {
//            deletedUsers.add(user);
//            usersRepository.delete(user);
//        }
//
//        return deletedUsers;
//    }
//
    public Optional<List<Users>> getAllWriter(){return usersRepository.findByTypeRole();}
    public Optional<List<Users>> getAllMod(){return usersRepository.getAllMod();}
    public Optional<List<Users>> getAllAdmin(){return usersRepository.getAllAdmin();}
    public Optional<List<Users>> getAllReader(){return usersRepository.getAllReader();}

    }
