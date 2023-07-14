package com.devmountain.capstone.dtos;


import com.devmountain.capstone.entities.Courses;
import com.devmountain.capstone.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursesDto implements Serializable {

    private Long courseId;
    private String courseName;
    private String courseDescription;
    private Integer courseCredits;
    private StudentDtos studentDtos;
    private List<StudentDtos> studentList;


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
        if (courses.getStudentCourses() != null) {
            for (Student s : courses.getStudentCourses()){
                this.studentList.add(new StudentDtos(s));
            }

        }
//        if (courses.getStudents() != null) {
//            this.studentDtos = new StudentDtos(courses.getStudents());
//        }

    }

}
