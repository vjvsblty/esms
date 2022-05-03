package com.app.esms.service;

import com.app.esms.entity.Login;
import com.app.esms.entity.User;

public interface UserService {

    String addUser(User user);

    User login(Login login);

    User getUserByEmailId(String email);
}
