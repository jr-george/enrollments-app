package com.trainibits.labs.enrollments_app.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EnrollmentResponse {
    private Integer studentID;
    private String studentName;
    private Integer age;
    private String major;
    private Double gpa;
    private Integer courseID;
    private String courseName;
    private String department;
    private Integer credits;
    private LocalDate enrollmentDate;
}
