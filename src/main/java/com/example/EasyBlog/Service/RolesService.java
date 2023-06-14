package com.example.EasyBlog.Service;


import com.example.EasyBlog.Entity.Roles;
import com.example.EasyBlog.Entity.Users;
import com.example.EasyBlog.Repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {
    @Autowired
    private static RolesRepository rolesRepository;

    public List<Roles> getAllRoles(){
        return rolesRepository.findAll();
    }
}