package com.trainibits.labs.enrollments_app.service;

import com.trainibits.labs.enrollments_app.dto.response.EnrollmentPageResponse;

public interface EnrollmentService {
    EnrollmentPageResponse getEnrollments(int currentPage, int pageSize);
}
