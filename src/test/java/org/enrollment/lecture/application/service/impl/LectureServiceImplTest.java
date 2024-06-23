package org.enrollment.lecture.application.service.impl;

import org.enrollment.lecture.domain.dto.lecture.LectureRequestDto;
import org.enrollment.lecture.domain.entity.Enrollment;
import org.enrollment.lecture.infra.repository.enrollment.EnrollmentRepository;
import org.enrollment.lecture.infra.repository.lecture.LectureRepository;
import org.enrollment.lecture.infra.repository.lecture.impl.LectureRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class LectureServiceImplTest {

    @InjectMocks LectureServiceImpl sut;

    @Mock LectureRepository lectureRepository;
    @Mock EnrollmentRepository enrollmentRepository;

    @Test
    void 특강을_수강한다() {
        // given
        long lectureId = 1L;
        long userId = 1L;
        LectureRequestDto requestDto = LectureRequestDto.of(lectureId, userId);
        given(enrollmentRepository.save(requestDto.enroll())).willReturn(any(Enrollment.class));

        // when
        sut.applyLecture(requestDto);

        // then
        then(enrollmentRepository).should().save(requestDto.enroll());
    }

}