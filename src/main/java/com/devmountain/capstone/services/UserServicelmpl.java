package com.devmountain.capstone.services;

import com.devmountain.capstone.dtos.UserDtos;
import com.devmountain.capstone.entities.User;
import com.devmountain.capstone.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServicelmpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //methods

    //adding user, registering
    @Override
    @Transactional
    public List<String> addUser(UserDtos userDtos) {
        System.out.println(userDtos);
        List<String> response = new ArrayList<>();
        User user = new User(userDtos);
        userRepository.saveAndFlush(user);
        response.add("http://localhost:8080/login.html");
        return response;
    }

    // logging in
    @Override
    public List<String> userLogin(UserDtos userDtos) {
//        List<String> response = new ArrayList<>();
//        Optional<User> userOptional = userRepository.findByUsername(userDtos.getUsername());
//
//        if (userOptional.isPresent()) {
//            if (passwordEncoder.matches(userDtos.getPassword(), userOptional.get().getPassword())) {
//                response.add("User Login Successful");
//                response.add(String.valueOf(userOptional.get().getId()));
//            } else {
//                response.add("Username or password incorrect");
//            }
//        } else {
//            response.add("Username or password incorrect");
//        }
//        return response;
//    }
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepository.findByUsername(userDtos.getUsername());

        if (userOptional.isPresent()) {
            if(passwordEncoder.matches(userDtos.getPassword(), userOptional.get().getPassword())) {
                String redirectUrl = "http://localhost:8080/home.html";
                response.add(redirectUrl);
                response.add(String.valueOf(userOptional.get().getId()));
            } else {
                response.add("Username or password incorrect");
            }
        }  else {
            response.add("Username or password is incorrect");
        }
        return response;
    }

}
