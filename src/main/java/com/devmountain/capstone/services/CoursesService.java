package com.devmountain.capstone.services;

import com.devmountain.capstone.dtos.CoursesDto;
import com.devmountain.capstone.entities.Courses;
import jakarta.transaction.Transactional;

public interface CoursesService {
    @Transactional
    Courses addCourse(CoursesDto coursesDto);

    // deleting a course
    void deleteCourseById(Long courseId);

    void editByCourseId(CoursesDto coursesDto);
}
