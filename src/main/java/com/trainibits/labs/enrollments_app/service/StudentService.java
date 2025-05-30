package com.trainibit.labs.enrollments_app.service;


import com.trainibits.labs.enrollments_app.dto.request.StudentRequest;
import com.trainibits.labs.enrollments_app.dto.response.StudentResponse;

public interface StudentService {
    StudentResponse insertStudent(StudentRequest studentRequest);
}
