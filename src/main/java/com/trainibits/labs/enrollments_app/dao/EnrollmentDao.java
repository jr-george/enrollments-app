package com.trainibits.labs.enrollments_app.dao;

import com.trainibits.labs.enrollments_app.dto.response.EnrollmentPageResponse;

public interface EnrollmentDao {
    EnrollmentPageResponse getEnrollments(Integer currentPage, Integer pageSize);
}
