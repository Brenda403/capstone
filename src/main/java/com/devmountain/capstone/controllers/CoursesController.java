package com.devmountain.capstone.controllers;

import com.devmountain.capstone.dtos.CoursesDto;
import com.devmountain.capstone.entities.Courses;
import com.devmountain.capstone.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

//    @PostMapping("/addCourse")
//    public CoursesDto addCourse(@RequestBody CoursesDto coursesDto) {
//        return coursesService.addCourse(coursesDto);
//    }

    @GetMapping()
    public List<CoursesDto> getAllCourses () {
        return coursesService.getAllCourses();

    }


    @DeleteMapping("/{courseId}")
    public void deleteCourseById(@PathVariable Long courseId) {
        coursesService.deleteCourseById(courseId);
    }

    @PutMapping("/{courseId}")
    public void editCourseById(@PathVariable Long courseId, @RequestBody CoursesDto coursesDto) {
        coursesDto.setCourseId(courseId);
        coursesService.editByCourseId(coursesDto);
    }


}
