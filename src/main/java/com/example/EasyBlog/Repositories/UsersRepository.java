package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface UsersRepository extends JpaRepository<Users,Long> {
    @Query("SELECT u FROM users u WHERE u.typeRoleEnum = 'READER'")
    Optional <List<Users>> getAllReader ();
    @Query("SELECT u FROM users u WHERE u.typeRoleEnum = 'ADMIN'")
    Optional <List<Users>> getAllAdmin ();
    @Query("SELECT u FROM users u WHERE u.typeRoleEnum = 'MOD'")
    Optional <List<Users>> getAllMod ();

    @Query("SELECT u FROM users u WHERE u.typeRoleEnum = 'WRITER'")
    Optional <List<Users>> findByTypeRole ();

    @Query("SELECT u FROM users u WHERE u.email = ?1")
    Optional<Users> findUserByEmail (String Email);

    @Query("SELECT u FROM users u WHERE u.typeStatus='ACTIVE'")
    Optional<List<Users>> findUsersByActive();

    @Query("SELECT u FROM users u WHERE u.typeStatus='INACTIVE'")
    Optional<List<Users>>findUsersByInactive();

    @Query("SELECT u FROM Users u WHERE u.typeStatus='SUSPENDED'")
    Optional<List<Users>>findUsersBySuspended();

}
