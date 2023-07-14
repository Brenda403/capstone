package com.devmountain.capstone.controllers;

import com.devmountain.capstone.dtos.CoursesDto;
import com.devmountain.capstone.dtos.StudentDtos;
import com.devmountain.capstone.entities.Student;
import com.devmountain.capstone.services.StudentService;
import com.devmountain.capstone.services.StudentServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody StudentDtos studentDtos) {
        System.out.println("\n" + studentDtos + "\n");
        return studentService.addStudent(studentDtos);
    }

    @PostMapping("/{studentId}/studentCourses")
    public void assignCoursesToStudent(@PathVariable Long studentId, @RequestBody CoursesDto coursesDto) {
        studentService.assignCoursesToStudent(studentId, coursesDto);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudentById(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
    }

//    @PutMapping("/{studentId}")
//    public void editStudentById(@PathVariable Long studentId, @RequestBody StudentDtos studentDtos) {
//        studentDtos.setStudentId(studentId);
//        studentService.editStudentById(studentDtos);
//    }

}
