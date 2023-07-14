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
        System.out.println("\n" + studentDtos + "\n");
        Student student = new Student(studentDtos);


        return studentRepository.save(student);

    }

    //assigning course to student
    @Override
    @Transactional
    public void assignCoursesToStudent(Long studentId, CoursesDto coursesDto) {
        Courses course = new Courses(coursesDto);
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(studentOptional.isPresent()) {
            System.out.println("\n" + coursesDto + "\n");
//            for(int i = 0; i < coursesDto.) {
//
//            }
            if (!studentOptional.get().getCoursesSet().contains(course)) {
                studentOptional.get().getCoursesSet().add(course);
                studentRepository.saveAndFlush(studentOptional.get());
            }
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

//    @Override
//    @Transactional
//    public void editStudentById(StudentDtos studentDtos) {
//        Optional<Student> studentOptional = studentRepository.findById(studentDtos.getStudentId());
//        studentOptional.ifPresent(student -> {
//            student.setStudentName(studentDtos.getStudentName());
//            student.setStudentEmail(studentDtos.getStudentEmail());
//
//            // Update course list
//            List<CoursesDto> coursesDtos = studentDtos.getCoursesList();
//            if (coursesDtos != null) {
//                List<Courses> updatedCoursesList = new ArrayList<>();
//                for (CoursesDto coursesDto : coursesDtos) {
//                    Courses courses = new Courses();
//                    courses.setCourseName(coursesDto.getCourseName());
//                    courses.setCourseDescription(coursesDto.getCourseDescription());
//                    courses.setCourseCredits(coursesDto.getCourseCredits());
//                    courses.setStudents(student);
//                    updatedCoursesList.add(courses);
//                }
//                student.setCoursesList(updatedCoursesList);
//            }
//
//            studentRepository.save(student);
//        });
//    }

}


