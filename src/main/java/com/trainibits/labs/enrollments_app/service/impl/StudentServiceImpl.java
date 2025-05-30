package com.trainibits.labs.enrollments_app.service.impl;

import com.trainibits.labs.enrollments_app.dao.StudentDao;
import com.trainibits.labs.enrollments_app.dto.request.StudentRequest;
import com.trainibits.labs.enrollments_app.dto.response.StudentResponse;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements com.trainibit.labs.enrollments_app.service.StudentService {


    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @Override
    public StudentResponse insertStudent(StudentRequest studentRequest) {
        StudentResponse studentResponse = new StudentResponse();
        Integer id = studentDao.insertStudent(studentRequest);
        studentResponse.setId(id);
        studentResponse.setAge(studentRequest.getAge());
        studentResponse.setMajor(studentRequest.getMajor());
        studentResponse.setName(studentRequest.getName());
        studentResponse.setGpa(studentRequest.getGpa());
        return studentResponse;
    }


}
