package com.devmountain.capstone.controllers;

import com.devmountain.capstone.dtos.UserDtos;
import com.devmountain.capstone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public List<String> addUser(@RequestBody UserDtos userDtos) {
        String passHash = passwordEncoder.encode(userDtos.getPassword());
        userDtos.setPassword(passHash);
        return userService.addUser(userDtos);
    }

    @PostMapping("/login")
    public List<String> userLogin(@RequestBody UserDtos userDtos) {
        return userService.userLogin(userDtos);
    }


}
