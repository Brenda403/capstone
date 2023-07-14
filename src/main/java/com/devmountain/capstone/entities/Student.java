package com.devmountain.capstone.entities;



import com.devmountain.capstone.dtos.CoursesDto;
import com.devmountain.capstone.dtos.StudentDtos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Student")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "student_name", length = 50)
    private String studentName;

    @Column(name = "student_email", length = 50)
    private String studentEmail;


//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @ManyToMany
    @JoinTable(name = "student_courses",joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonBackReference
    private Set<Courses> coursesSet = new HashSet<>();

    //constructors, getters, setters

    public Student(StudentDtos studentDtos) {
        if (studentDtos.getStudentName() != null) {
            this.studentName = studentDtos.getStudentName();
        }
        if (studentDtos.getStudentEmail() != null) {
            this.studentEmail = studentDtos.getStudentEmail();
        }
        if (studentDtos.getCoursesList() != null) {
            for (int i = 0; i < studentDtos.getCoursesList().size(); i++) {
                Courses courses = new Courses(studentDtos.getCoursesList().get(i));
                this.coursesSet.add(courses);
            }

        }
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Set<Courses> getCoursesSet() {
        return coursesSet;
    }

    public void setCoursesList(Set<Courses> coursesSet) {
        this.coursesSet = coursesSet;
    }

    public Student() {

    }

    public Student(Long studentId, String studentName, String studentEmail, Set<Courses> coursesSet) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.coursesSet = coursesSet;
    }



}
