package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface UsersRepository extends JpaRepository<Users,Long> {

    Optional<Users> findUserByEmail (String Email);
}
