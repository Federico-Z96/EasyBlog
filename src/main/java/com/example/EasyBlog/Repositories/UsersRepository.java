package com.example.EasyBlog.Repositories;

import com.example.EasyBlog.Entity.Comments;
import com.example.EasyBlog.Entity.Enum.TypeRoleEnum;
import com.example.EasyBlog.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    @Query("SELECT u FROM Users u WHERE u.roles = 0")
    List<Users> getAllReader ();
    @Query("SELECT u FROM Users u WHERE u.roles = 3")
    List<Users> getAllAdmin ();
    @Query("SELECT u FROM Users u WHERE u.roles = 2")
    List<Users> getAllMod ();

    @Query("SELECT u FROM Users u WHERE u.roles=1")
    List<Users> getallWriter();
    @Query("SELECT u FROM Users u WHERE u.roles = :roles")
    List<Users> findByTypeRole (@Param("roles")TypeRoleEnum typeRoleEnum);


    @Query("SELECT u FROM Users u WHERE u.email = :email")
    Optional<Users> findUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM Users u WHERE u.typeStatus=0")
    List<Users> findUsersByActive();

    @Query("SELECT u FROM Users u WHERE u.typeStatus=1")
    List<Users> findUsersByInactive();

    @Query("SELECT u FROM Users u WHERE u.typeStatus=2")
    List<Users> findUsersBySuspended();

}
