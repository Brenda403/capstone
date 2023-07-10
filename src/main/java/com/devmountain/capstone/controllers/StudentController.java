package com.devmountain.capstone.controllers;

import com.devmountain.capstone.dtos.StudentDtos;
import com.devmountain.capstone.entities.Student;
import com.devmountain.capstone.services.StudentService;
import com.devmountain.capstone.services.StudentServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody StudentDtos studentDtos) {
        return studentService.addStudent(studentDtos);
    }

    @PostMapping("/{studentId}/studentCourses")
    public void assignCoursesToStudent(@PathVariable Long studentId, @RequestBody List<Long> courseIds) {
        studentService.assignCoursesToStudent(studentId, courseIds);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudentById(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
    }

    @PutMapping("/{studentId}")
    public void editStudentById(@PathVariable Long studentId, @RequestBody StudentDtos studentDtos) {
        studentDtos.setStudentId(studentId);
        studentService.editStudentById(studentDtos);
    }

}
