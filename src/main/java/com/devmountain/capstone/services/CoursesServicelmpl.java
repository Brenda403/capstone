package com.devmountain.capstone.services;

import com.devmountain.capstone.dtos.CoursesDto;
import com.devmountain.capstone.entities.Courses;
import com.devmountain.capstone.repositories.CoursesRepository;
import com.devmountain.capstone.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoursesServicelmpl implements CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private StudentRepository studentRepository;

    // adding a course

    @Override
    @Transactional
    public Courses addCourse(CoursesDto coursesDto) {
        Courses courses = new Courses();
        courses.setCourseId(coursesDto.getCourseId());
        courses.setCourseName(coursesDto.getCourseName());
        courses.setCourseCredits(coursesDto.getCourseCredits());
        courses.setCourseDescription(coursesDto.getCourseDescription());

        return coursesRepository.save(courses);
    }

    // deleting a course
    @Override
    public void deleteCourseById(Long courseId) {
        Optional<Courses> coursesOptional = coursesRepository.findById(courseId);
        coursesOptional.ifPresent(courses -> coursesRepository.delete(courses));
    }

    // editing course information

    @Override
    public void editByCourseId(CoursesDto coursesDto) {
        Optional<Courses> coursesOptional = coursesRepository.findById(coursesDto.getCourseId());
        coursesOptional.ifPresent(courses -> {
            courses.setCourseName(coursesDto.getCourseName());
            courses.setCourseDescription(coursesDto.getCourseDescription());
            courses.setCourseCredits(coursesDto.getCourseCredits());
        });
    }


}
