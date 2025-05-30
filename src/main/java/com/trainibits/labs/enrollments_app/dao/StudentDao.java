package com.trainibits.labs.enrollments_app.dao;

import com.trainibits.labs.enrollments_app.dto.request.StudentRequest;

public interface StudentDao {
    Integer insertStudent (StudentRequest studentRequest);
}
