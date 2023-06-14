package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UsersController {
    @Autowired
    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/register")
    public Users createUser(@RequestBody Users users){
        return usersService.createUser(users);
    }

    @GetMapping("/get/{id}")
    public Users getUser(@PathVariable Long idUser){return usersService.getUserById(idUser); }

    @GetMapping("/getAll")
    public List<Users> getAllLocations(){return usersService.getAllUsers(); }

    @PutMapping("/update")
    public Users updateUser (@RequestBody Users users){return usersService.updateUser(users); }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long idUser){usersService.deleteUser(idUser); }

    @DeleteMapping("/deleteAll")
    public List<Users> deleteAll(){return usersService.deleteAllUsers(); }

    @GetMapping("/getUsersActive")
    public Optional<List<Users>> getUsersActive (){return usersService.getAllActiveUsers();}
    @GetMapping("/getUsersInactive")
    public Optional<List<Users>> getUsersInactive (){return usersService.getAllInactiveUsers();}
    @GetMapping("/getUsersSuspended")
    public Optional<List<Users>> getUsersSuspended (){return usersService.getAllSuspendedUsers();}


}
