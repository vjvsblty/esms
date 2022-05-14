package com.app.esms.service;

import com.app.esms.entity.Login;
import com.app.esms.entity.Users;

import java.util.List;

public interface UserService {

    String addUser(Users user);

    Users login(Login login);

    Users getUserByEmailId(String email);

    List<Users> findAllUsers();
}
