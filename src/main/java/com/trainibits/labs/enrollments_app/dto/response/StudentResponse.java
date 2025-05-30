package com.trainibits.labs.enrollments_app.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {
    private Integer id;
    private String name;
    private Integer age;
    private String major;
    private Double gpa;
}
