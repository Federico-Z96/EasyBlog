package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    @Query("SELECT u FROM Users u WHERE u.roles = 'Reader'")
    Optional <List<Users>> getAllReader ();
    @Query("SELECT u FROM Users u WHERE u.roles = 'Admin'")
    Optional <List<Users>> getAllAdmin ();
    @Query("SELECT u FROM Users u WHERE u.roles = 'Mod'")
    Optional <List<Users>> getAllMod ();

    @Query("SELECT u FROM Users u WHERE u.roles = 'Writer'")
    Optional <List<Users>> findByTypeRole ();


    @Query("SELECT u FROM Users u WHERE u.email = :email")
    Optional<Users> findUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM Users u WHERE u.typeStatus='active'")
    Optional<List<Users>> findUsersByActive();

    @Query("SELECT u FROM Users u WHERE u.typeStatus='inactive'")
    Optional<List<Users>>findUsersByInactive();

    @Query("SELECT u FROM Users u WHERE u.typeStatus='suspended'")
    Optional<List<Users>>findUsersBySuspended();

}
