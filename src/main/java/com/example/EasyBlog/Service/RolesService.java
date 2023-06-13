package com.example.EasyBlog.Service;


import com.example.EasyBlog.Repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {
    @Autowired
    private static RolesRepository rolesRepository;
}