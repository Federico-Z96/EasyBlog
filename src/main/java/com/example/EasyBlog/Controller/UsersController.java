package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Entity.Articles;
import com.example.EasyBlog.Entity.Enum.TypeRoleEnum;
import com.example.EasyBlog.Entity.Enum.TypeStatusEnum;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

    @Operation(summary = "User registration from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully register",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Email", content = @Content)
    })
    @PostMapping("/register")
    public ResponseEntity<String> createUser(@Valid @RequestBody Users users, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Something error");
        } else {
            usersService.createUser(users);
            return ResponseEntity.ok().body("User registered!!");
        }
    }


    @Operation(summary = "Get user by id from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content)
    })



    @GetMapping("/get/id/{id}")
    public ResponseEntity<Users> getUser(@PathVariable ("id") Long idUser) {
            Users users = usersService.getUserById(idUser);
            if (users == null){
                return ResponseEntity.badRequest().build();
            }
        return ResponseEntity.ok().body(usersService.getUserById(idUser));
    }

    @Operation(summary = "Get user by email from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Email", content = @Content)
    })
    @GetMapping("/get/email/{email}")
    public ResponseEntity<Users> getUser(@PathVariable ("email") String email) {
        Users users = usersService.getUserByEmail(email);
        if (users == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(usersService.getUserByEmail(email));
    }

    @Operation(summary = "Get all users by email from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
    })
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllLocations() {
        List<Users> users = usersService.getAllUsers();

        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @Operation(summary = "Update user from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully uptated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@RequestBody Users users, @PathVariable ("id") Long id) {
        Users updatedUser = usersService.updateUser(users, id);

        if (updatedUser != null) {
            return ResponseEntity.ok().body("Success update");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");

        }
    }

    @Operation(summary = "Get roles users from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Email", content = @Content)
    })

    @GetMapping("/getRoleUsers/{roles}")
    public ResponseEntity<?> getAllWriter(@PathVariable TypeRoleEnum roles) {
        List<Users> rolesUsers = usersService.getAllUsersRoles(roles);

        if (!rolesUsers.isEmpty()) {
            return ResponseEntity.ok((rolesUsers));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @Operation(summary = "Get user status from easy blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articles.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error", content = @Content)
    })

    @GetMapping("/getStatusUsers/{status}")
    public ResponseEntity<?> getAllStatus(@PathVariable TypeStatusEnum status) {
        List<Users> statusUsers = usersService.getAllUsersStatus(status);

        if (!statusUsers.isEmpty()) {
            return ResponseEntity.ok((statusUsers));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }
}
