package com.trainibits.labs.enrollments_app.dao.impl;

import com.trainibits.labs.enrollments_app.dao.StudentDao;
import com.trainibits.labs.enrollments_app.dto.request.StudentRequest;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDaoImpl implements StudentDao {
    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    public StudentDaoImpl (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @PostConstruct
    public void init(){
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("InsertStudente");
    }
    @Override
    public Integer insertStudent(StudentRequest studentRequest) {
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_Name", studentRequest.getName());
        inParams.put("p_Age", studentRequest.getAge());
        inParams.put("p_Major", studentRequest.getMajor());
        inParams.put("p_GPA", studentRequest.getGpa());

        Map<String, Object> out = simpleJdbcCall.execute((inParams));
        return (Integer) out.get("p_NewStudentID");
    }
}
