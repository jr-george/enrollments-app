package com.trainibits.labs.enrollments_app.service.impl;

import com.trainibits.labs.enrollments_app.dao.EnrollmentDao;
import com.trainibits.labs.enrollments_app.dto.response.EnrollmentPageResponse;
import com.trainibits.labs.enrollments_app.service.EnrollmentService;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentDao enrollmentDao;

    EnrollmentServiceImpl(EnrollmentDao enrollmentDao) {
        this.enrollmentDao = enrollmentDao;
    }

    @Override
    public EnrollmentPageResponse getEnrollments(int currentPage, int pageSize) {
        return enrollmentDao.getEnrollments(currentPage, pageSize);
    }
}
