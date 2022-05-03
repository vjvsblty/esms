package com.app.esms.repository;

import com.app.esms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("FROM User u where u.email = :email AND u.password = :password")
    User findByEmailIdAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("FROM User u where u.email = :email")
    User findByEmail(@Param("email") String email);
}
