package org.enrollment.lecture.infra.repository.enrollment;

import org.enrollment.lecture.domain.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentJpaRepository extends JpaRepository<Enrollment, Long>, EnrollmentRepository {
}
