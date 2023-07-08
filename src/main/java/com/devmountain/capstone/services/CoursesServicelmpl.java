package com.devmountain.capstone.services;

import com.devmountain.capstone.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursesServicelmpl {
    @Autowired
    private CoursesRepository coursesRepository;
}
