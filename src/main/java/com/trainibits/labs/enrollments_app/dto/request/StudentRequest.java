package com.trainibits.labs.enrollments_app.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {
    private String name;
    private int age;
    private String major;
    private double gpa;
}
