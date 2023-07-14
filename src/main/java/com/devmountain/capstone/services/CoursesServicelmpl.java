package com.devmountain.capstone.services;

import com.devmountain.capstone.dtos.CoursesDto;
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
public class CoursesServicelmpl implements CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private StudentRepository studentRepository;

    // adding a course

//    @Override
//    @Transactional
//    public CoursesDto addCourse(CoursesDto coursesDto) {
//        Courses courses = new Courses(coursesDto);
//        System.out.println("\n" + coursesDto);
//        //Optional<Student> studentOptional = studentRepository.findBy...(variableof student) instead of new Student()
//        courses.setStudents(new Student(1L, "name", "email", null)); // come back to this with
//       coursesRepository.saveAndFlush(courses);
//       CoursesDto newDto = new CoursesDto(courses);
//        System.out.println("/n" + newDto);
//       return newDto;
//    }

    // deleting a course
    @Override
    @Transactional
    public void deleteCourseById(Long courseId) {
        Optional<Courses> coursesOptional = coursesRepository.findById(courseId);
        coursesOptional.ifPresent(courses -> coursesRepository.delete(courses));
    }

    // editing course information

    @Override
    @Transactional
    public void editByCourseId(CoursesDto coursesDto) {
        Optional<Courses> coursesOptional = coursesRepository.findById(coursesDto.getCourseId());
        coursesOptional.ifPresent(courses -> {
            courses.setCourseName(coursesDto.getCourseName());
            courses.setCourseDescription(coursesDto.getCourseDescription());
            courses.setCourseCredits(coursesDto.getCourseCredits());
        });
    }

    //display/get all courses
    @Override
    @Transactional
    public List<CoursesDto> getAllCourses () {
        List<Courses> coursesList = coursesRepository.findAll();
        List<CoursesDto> coursesDtoList = new ArrayList<>(coursesList.size());
        for (Courses c : coursesList) {
            coursesDtoList.add(new CoursesDto(c));
        }

        return coursesDtoList;
    }


}
