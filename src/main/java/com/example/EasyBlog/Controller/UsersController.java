package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UsersController {

//    @Autowired
//    private UsersService usersService;
//
//    public UsersController(UsersService usersService) {
//        this.usersService = usersService;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<Users> createUser(@RequestBody Users users) {
//        Users createdUser = usersService.createUser(users);
//        return ResponseEntity.ok(createdUser);
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<?> getUser(@PathVariable Long idUser) {
//        Users user = usersService.getUserById(idUser);
//
//        if (user != null) {
//            return ResponseEntity.ok(user);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
//        }
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<?> getAllLocations() {
//        List<Users> users = usersService.getAllUsers();
//
//        if (!users.isEmpty()) {
//            return ResponseEntity.ok(users);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
//        }
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updateUser(@RequestBody Users users, @PathVariable Long id) {
//        Users updatedUser = usersService.updateUser(users,id);
//
//        if (updatedUser != null) {
//            return ResponseEntity.ok(updatedUser);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
//
//        }
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteUserById(@PathVariable Long idUser){usersService.deleteUser(idUser); }
//
//    @DeleteMapping("/deleteAll")
//    public List<Users> deleteAll(){return usersService.deleteAllUsers(); }
//
//    @GetMapping("/getUsersActive")
//    public ResponseEntity<?> getUsersActive() {
//        Optional<List<Users>> activeUsers = usersService.getAllActiveUsers();
//
//        if (activeUsers.isPresent()) {
//            return ResponseEntity.ok(activeUsers.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
//        }
//    }
//    @GetMapping("/getUsersInactive")
//    public ResponseEntity<?> getUsersInactive() {
//        Optional<List<Users>> inactiveUsers = usersService.getAllInactiveUsers();
//
//        if (inactiveUsers.isPresent()) {
//            return ResponseEntity.ok(inactiveUsers.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
//        }
//    }
//    @GetMapping("/getUsersSuspended")
//    public ResponseEntity<?> getUsersSuspended() {
//        Optional<List<Users>> suspendedUsers = usersService.getAllSuspendedUsers();
//
//        if (suspendedUsers.isPresent()) {
//            return ResponseEntity.ok(suspendedUsers.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
//        }
//    }
//
//
//    //@GetMapping("/getUsersWriter")
//    //public ResponseEntity<?> getAllWriter() {
//        //Optional<List<Users>> writerUsers = usersService.getAllWriter();
//
//        //if (writerUsers.isPresent()) {
//           // return ResponseEntity.ok(writerUsers.get());
//        //} else {
//        //    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
//        //}
//    //}
//
//
//    //@GetMapping("/getReaderUsers")
//    //public ResponseEntity<?> getUsersReader() {
//        //Optional<List<Users>> usersReader = usersService.getAllReader();
//
//        //if (usersReader.isPresent()) {
//            //return ResponseEntity.ok(usersReader.get());
//        //} else {
//           // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
//       // }
//   // }
//
//    @GetMapping("/getUsersMod")
//    public ResponseEntity<?> getUsersMod() {
//        Optional<List<Users>> modUsers = usersService.getAllMod();
//
//        if (modUsers.isPresent()) {
//            return ResponseEntity.ok(modUsers.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
//        }
//    }
//
//    @GetMapping("/getUsersAdmin")
//    public ResponseEntity<?> getUsersAdmin() {
//        Optional<List<Users>> adminUsers = usersService.getAllAdmin();
//
//        if (adminUsers.isPresent()) {
//            return ResponseEntity.ok(adminUsers.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
//        }
//    }


}
