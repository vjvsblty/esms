package com.app.esms.service;

import com.app.esms.entity.Login;
import com.app.esms.entity.Users;
import com.app.esms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUser(Users user) {
        Users existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser == null){
            userRepository.save(user);
            return "User added!";
        }else{
            return null;
        }
    }

    @Override
    public Users login(Login login) {
        Users user = userRepository.findByEmailIdAndPassword(login.getEmail(), login.getPassword());
        return user != null ? user : null;
    }

    @Override
    public Users getUserByEmailId(String email) {
        Users user = userRepository.findByEmail(email);
        return user != null ? user : null;
    }

    @Override
    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }
}
