package com.trainibits.labs.enrollments_app.controller;

import com.trainibits.labs.enrollments_app.dto.response.EnrollmentPageResponse;
import com.trainibits.labs.enrollments_app.service.EnrollmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class EnrollmentController {
    private EnrollmentService enrollmentService;

    @GetMapping("/enrollments")
    public EnrollmentPageResponse getEnrollments(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "4") int size) {
        return enrollmentService.getEnrollments(page,size);
    }
}
