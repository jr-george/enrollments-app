package com.trainibits.labs.enrollments_app.dao.impl;

import com.trainibits.labs.enrollments_app.dao.EnrollmentDao;
import com.trainibits.labs.enrollments_app.dto.response.EnrollmentPageResponse;
import com.trainibits.labs.enrollments_app.dto.response.EnrollmentResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EnrollmentDaoImpl implements EnrollmentDao {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    public EnrollmentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void init(){
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("GetStudentCourseEnrollment")
                .returningResultSet("data", BeanPropertyRowMapper.newInstance(EnrollmentResponse.class));
    }
    @Override
    public EnrollmentPageResponse getEnrollments(Integer currentPage, Integer pageSize) {
        Integer offset = (currentPage - 1) * pageSize;

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_Limit", pageSize);
        inParams.put("p_Offset", offset);

        Map<String, Object> result = simpleJdbcCall.execute(inParams);

        List<EnrollmentResponse> data = (List<EnrollmentResponse>) result.get("data");
        Integer totalRecords = ((Number) result.get("p_RecordCount")).intValue();
        Integer totalPages = (int) Math.ceil((double) totalRecords / pageSize);

        EnrollmentPageResponse enrollmentPageResponse = new EnrollmentPageResponse();enrollmentPageResponse.setCurrentPage(currentPage);
        enrollmentPageResponse.setPageSize(pageSize);
        enrollmentPageResponse.setTotalRecords(totalRecords);
        enrollmentPageResponse.setTotalPages(totalPages);
        enrollmentPageResponse.setData(data);

        return enrollmentPageResponse;
    }
}
