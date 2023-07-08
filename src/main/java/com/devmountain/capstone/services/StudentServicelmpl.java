package com.devmountain.capstone.services;

import com.devmountain.capstone.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServicelmpl {
    @Autowired
    private StudentRepository studentRepository;

}
