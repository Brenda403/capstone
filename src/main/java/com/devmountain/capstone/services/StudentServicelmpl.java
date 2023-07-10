package com.devmountain.capstone.services;

import com.devmountain.capstone.dtos.CoursesDto;
import com.devmountain.capstone.dtos.StudentDtos;
import com.devmountain.capstone.entities.Courses;
import com.devmountain.capstone.entities.Student;
import com.devmountain.capstone.repositories.CoursesRepository;
import com.devmountain.capstone.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServicelmpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CoursesRepository coursesRepository;

    // adding a student record
    @Override
    @Transactional
    public  Student addStudent(StudentDtos studentDtos) {
        Student student = new Student();
        student.setStudentId(studentDtos.getStudentId());
        student.setStudentName(studentDtos.getStudentName());
        student.setStudentEmail(studentDtos.getStudentEmail());
        //Course List...

        if(studentDtos.getCoursesList() != null) {
            List<Courses> coursesList = new ArrayList<>();
            for (CoursesDto coursesDto : studentDtos.getCoursesList()) {
                Courses courses = new Courses();
                courses.setCourseName(coursesDto.getCourseName());
                courses.setCourseDescription(coursesDto.getCourseDescription());
                courses.setCourseCredits(coursesDto.getCourseCredits());
                //student reference
                courses.setStudents(student);
                coursesList.add(courses);

            }
            student.setCoursesList(coursesList);
        }
        return studentRepository.save(student);

    }

    //assigning course to student

    @Override
    public void assignCoursesToStudent(Long studentId, List<Long> courseIds) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(studentOptional.isPresent()) {
            Student student = studentOptional.get();
            List<Courses> coursesToAdd = coursesRepository.findAllById(courseIds);
            student.setCoursesList(coursesToAdd);
            studentRepository.save(student);
        } else {
            throw new IllegalArgumentException("Student with ID: " + studentId + " not found.");
        }
    }

    // deleting a student record
    @Override
    @Transactional
    public void deleteStudentById(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        studentOptional.ifPresent(student -> studentRepository.delete(student));

    }

    // edit student record

    @Override
    @Transactional
    public void editStudentById(StudentDtos studentDtos) {
        Optional<Student> studentOptional = studentRepository.findById(studentDtos.getStudentId());
        studentOptional.ifPresent(student -> {
            student.setStudentName(studentDtos.getStudentName());
            student.setStudentEmail(studentDtos.getStudentEmail());

            // Update course list
            List<CoursesDto> coursesDtos = studentDtos.getCoursesList();
            if (coursesDtos != null) {
                List<Courses> updatedCoursesList = new ArrayList<>();
                for (CoursesDto coursesDto : coursesDtos) {
                    Courses courses = new Courses();
                    courses.setCourseName(coursesDto.getCourseName());
                    courses.setCourseDescription(coursesDto.getCourseDescription());
                    courses.setCourseCredits(coursesDto.getCourseCredits());
                    courses.setStudents(student);
                    updatedCoursesList.add(courses);
                }
                student.setCoursesList(updatedCoursesList);
            }

            studentRepository.save(student);
        });
    }

}


