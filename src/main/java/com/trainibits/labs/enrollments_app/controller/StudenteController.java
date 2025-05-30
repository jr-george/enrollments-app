package com.trainibits.labs.enrollments_app.controller;

import com.trainibits.labs.enrollments_app.dto.request.StudentRequest;
import com.trainibits.labs.enrollments_app.dto.response.StudentResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("api/v1")
public class StudenteController {

    private com.trainibit.labs.enrollments_app.service.StudentService studentService;

    @PostMapping("students")
    public StudentRequest insertStudent(@RequestBody StudentRequest studentRequest){
        studentService.insertStudent(studentRequest);
        return studentRequest;
    }
}
