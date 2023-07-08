package com.devmountain.capstone.services;

import com.devmountain.capstone.dtos.UserDtos;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    //adding user, registering
    @Transactional
    List<String> addUser(UserDtos userDtos);

    // logging in
    List<String> userLogin(UserDtos userDtos);
}
