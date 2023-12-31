package com.devmountain.capstone.entities;

import com.devmountain.capstone.dtos.CoursesDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "course_name", length = 50)
    private String courseName;

    @Column(name = "course_description", columnDefinition = "text")
    private String courseDescription;

    @Column(name = "course_credits")
    private Integer courseCredits;

    @ManyToMany(mappedBy = "coursesSet")
    @JsonBackReference
    Set<Student> studentCourses = new HashSet<>();


    //constructors, getters, setters


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Set<Student> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(Set<Student> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Integer getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(Integer courseCredits) {
        this.courseCredits = courseCredits;
    }

//    public Student getStudents() {
//        return student;
//    }
//
//    public void setStudents(Student student) {
//        this.student = student;
//    }

    public Courses() {
    }

    public Courses(Long courseId, String courseName, String courseDescription, Integer courseCredits, Set<Student> studentCourses) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseCredits = courseCredits;
        this.studentCourses = studentCourses;
    }
//    public Courses(Long courseId, String courseName, String courseDescription, Integer courseCredits, Student student) {
//        this.courseId = courseId;
//        this.courseName = courseName;
//        this.courseDescription = courseDescription;
//        this.courseCredits = courseCredits;
//        this.student = student;
//    }

    public Courses(CoursesDto coursesDto) {
        if (coursesDto.getCourseName() != null) {
            this.courseName = coursesDto.getCourseName();
        }
        if (coursesDto.getCourseCredits() != null) {
            this.courseCredits = coursesDto.getCourseCredits();
        }
        if (coursesDto.getCourseDescription() != null) {
            this.courseDescription = coursesDto.getCourseDescription();
        }
    }

}
