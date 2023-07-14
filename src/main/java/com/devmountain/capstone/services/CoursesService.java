package com.devmountain.capstone.services;

import com.devmountain.capstone.dtos.CoursesDto;
import com.devmountain.capstone.entities.Courses;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CoursesService {
//    @Transactional
//    CoursesDto addCourse(CoursesDto coursesDto);

    // deleting a course
    @Transactional
    void deleteCourseById(Long courseId);
    @Transactional
    void editByCourseId(CoursesDto coursesDto);

    @Transactional
   List<CoursesDto> getAllCourses ();
}
