package org.enrollment.lecture.infra.repository.enrollment.impl;

import lombok.RequiredArgsConstructor;
import org.enrollment.lecture.domain.entity.Enrollment;
import org.enrollment.lecture.infra.repository.enrollment.EnrollmentRepository;
import org.enrollment.lecture.infra.repository.enrollment.EnrollmentSqlMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EnrollmentSqlMapperImpl {

    private final EnrollmentSqlMapper enrollmentSqlMapper;

//    @Override
//    public Enrollment findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public Enrollment save(Enrollment enrollment) {
//        return null;
//    }
}
