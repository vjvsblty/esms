package com.app.esms.repository;

import com.app.esms.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    @Query("FROM Users u where u.email = :email AND u.password = :password")
    Users findByEmailIdAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("FROM Users u where u.email = :email")
    Users findByEmail(@Param("email") String email);
}
