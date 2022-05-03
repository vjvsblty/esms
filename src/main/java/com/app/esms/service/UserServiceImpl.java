package com.app.esms.service;

import com.app.esms.entity.Login;
import com.app.esms.entity.User;
import com.app.esms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUser(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser == null){
            userRepository.save(user);
            return "User added!";
        }else{
            return null;
        }
    }

    @Override
    public User login(Login login) {
        User user = userRepository.findByEmailIdAndPassword(login.getEmail(), login.getPassword());
        return user != null ? user : null;
    }

    @Override
    public User getUserByEmailId(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }
}
