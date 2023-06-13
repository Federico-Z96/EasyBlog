package com.example.EasyBlog.Controller;

import com.example.EasyBlog.Service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Roles")
public class RolesController {
    @Autowired
    private RolesService rolesService;
}
