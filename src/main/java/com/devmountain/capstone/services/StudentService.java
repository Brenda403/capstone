package com.devmountain.capstone.services;

import com.devmountain.capstone.dtos.StudentDtos;
import com.devmountain.capstone.entities.Student;
import jakarta.transaction.Transactional;

public interface StudentService {
    // adding a student record
    @Transactional
    Student addStudent(StudentDtos studentDtos);

    // deleting a student record
    @Transactional
    void deleteStudentById(Long studentId);

    @Transactional
    void editStudentById(StudentDtos studentDtos);
}
