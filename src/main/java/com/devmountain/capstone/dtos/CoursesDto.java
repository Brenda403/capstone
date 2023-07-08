package com.devmountain.capstone.dtos;


import com.devmountain.capstone.entities.Courses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursesDto implements Serializable {

    private Long courseId;
    private String courseName;
    private String courseDescription;
    private Integer courseCredits;

    public CoursesDto(Courses courses) {

        if (courses.getCourseId() != null) {
            this.courseId = courses.getCourseId();
        }
        if (courses.getCourseName() != null) {
            this.courseName = courses.getCourseName();
        }
        if (courses.getCourseDescription() != null) {
            this.courseDescription = courses.getCourseDescription();
        }
        if (courses.getCourseCredits() != null) {
            this.courseCredits = courses.getCourseCredits();
        }

    }

}
