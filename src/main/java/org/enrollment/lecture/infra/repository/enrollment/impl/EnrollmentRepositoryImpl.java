package org.enrollment.lecture.infra.repository.enrollment.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.enrollment.lecture.domain.entity.Enrollment;
import org.enrollment.lecture.infra.repository.enrollment.EnrollmentJpaRepository;
import org.enrollment.lecture.infra.repository.enrollment.EnrollmentRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EnrollmentRepositoryImpl implements EnrollmentRepository {

    private final EnrollmentJpaRepository enrollmentJpaRepository;

    @Override
    public Enrollment findById(Long id) {
        return enrollmentJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("lecture not found : id - %d".formatted(id)));
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return enrollmentJpaRepository.save(enrollment);
    }

}
