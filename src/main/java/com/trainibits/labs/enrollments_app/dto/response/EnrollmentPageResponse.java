package com.trainibits.labs.enrollments_app.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

@Getter
@Setter
public class EnrollmentPageResponse {
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalRecords;
    private Integer totalPages;
    private List<EnrollmentResponse> data;
}
