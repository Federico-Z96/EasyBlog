package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createUser(@RequestBody Users users) {
        return usersService.createUser(users);
    }




    @GetMapping("/get/id/{id}")
    public ResponseEntity<Users> getUser(@PathVariable ("id") Long idUser) {
            Users users = usersService.getUserById(idUser);
            if (users == null){
                return ResponseEntity.badRequest().build();
            }
        return ResponseEntity.ok().body(usersService.getUserById(idUser));
    }

    @GetMapping("/get/email/{email}")
    public ResponseEntity<Users> getUser(@PathVariable ("email") String email) {
        Users users = usersService.getUserByEmail(email);
        if (users == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(usersService.getUserByEmail(email));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllLocations() {
        List<Users> users = usersService.getAllUsers();

        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@RequestBody Users users, @PathVariable ("id") Long id) {
        Users updatedUser = usersService.updateUser(users,id);

        if (updatedUser != null) {
            return ResponseEntity.ok().body("Success update");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");

        }
    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteUserById(@PathVariable Long idUser){usersService.deleteUser(idUser); }
//
//    @DeleteMapping("/deleteAll")
//    public List<Users> deleteAll(){return usersService.deleteAllUsers(); }
//
    @GetMapping("/getUsersActive")
    public ResponseEntity<?> getUsersActive() {
        List<Users> activeUsers = usersService.getAllActiveUsers();

        if (activeUsers.isEmpty()) {
            return ResponseEntity.ok(activeUsers);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }
    @GetMapping("/getUsersInactive")
    public ResponseEntity<?> getUsersInactive() {
        List<Users> inactiveUsers = usersService.getAllInactiveUsers();

        if (inactiveUsers.isEmpty()) {
            return ResponseEntity.ok(inactiveUsers);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }
    @GetMapping("/getUsersSuspended")
    public ResponseEntity<?> getUsersSuspended() {
        List<Users> suspendedUsers = usersService.getAllSuspendedUsers();

        if (!suspendedUsers.isEmpty()) {
            return ResponseEntity.ok(suspendedUsers);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }


    @GetMapping("/getUsersWriter")
    public ResponseEntity<?> getAllWriter() {
        List<Users> writerUsers = usersService.getAllWriter();

        if (!writerUsers.isEmpty()) {
            return ResponseEntity.ok((writerUsers));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }


    @GetMapping("/getReaderUsers")
    public ResponseEntity<?> getUsersReader() {
        List<Users> usersReader = usersService.getAllReader();

        if (!usersReader.isEmpty()) {
            return ResponseEntity.ok(usersReader);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @GetMapping("/getUsersMod")
    public ResponseEntity<?> getUsersMod() {
        List<Users> modUsers = usersService.getAllMod();

        if (!modUsers.isEmpty()) {
            return ResponseEntity.ok(modUsers);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @GetMapping("/getUsersAdmin")
    public ResponseEntity<?> getUsersAdmin() {
        List<Users> adminUsers = usersService.getAllAdmin();

        if (!adminUsers.isEmpty()) {
            return ResponseEntity.ok(adminUsers);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }


}
