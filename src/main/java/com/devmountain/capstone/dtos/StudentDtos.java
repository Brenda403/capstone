package com.devmountain.capstone.dtos;

import com.devmountain.capstone.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDtos implements Serializable {
    private Long studentId;
    private String studentName;
    private String studentEmail;
    private List<CoursesDto> coursesList;

    public StudentDtos(Student student){
        if (student.getStudentId() != null) {
            this.studentId = student.getStudentId();
        }
        if (student.getStudentName() != null) {
            this.studentName = student.getStudentName();
        }
        if (student.getStudentEmail() != null) {
            this.studentEmail = student.getStudentEmail();
        }
    }

}
