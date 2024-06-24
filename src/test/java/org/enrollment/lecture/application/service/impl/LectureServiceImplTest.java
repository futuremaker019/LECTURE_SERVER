package org.enrollment.lecture.application.service.impl;

import org.enrollment.lecture.domain.dto.lecture.LectureRequestDto;
import org.enrollment.lecture.domain.entity.Enrollment;
import org.enrollment.lecture.domain.entity.Lecture;
import org.enrollment.lecture.domain.entity.UserAccount;
import org.enrollment.lecture.infra.repository.enrollment.EnrollmentJpaRepository;
import org.enrollment.lecture.infra.repository.enrollment.EnrollmentRepository;
import org.enrollment.lecture.infra.repository.lecture.LectureRepository;
import org.enrollment.lecture.infra.repository.userAccount.UserAccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
class LectureServiceImplTest {

    @InjectMocks LectureServiceImpl sut;

    @Mock LectureRepository lectureRepository;
    @Mock UserAccountRepository userAccountRepository;
    @Mock EnrollmentRepository enrollmentRepository;

    @DisplayName("강의 id와 사용자 id로 특강을 수강한다")
    @Test
    void givenLectureIdAndUserId_whenSavingEnrollment_thenNothingReturn() {
        // given
        long lectureId = 1L;
        long userId = 1L;
        long enrollmentId = 1L;
        LectureRequestDto requestDto = LectureRequestDto.of(lectureId, userId);
        Lecture lecture = Lecture.of(lectureId);
        UserAccount userAccount = UserAccount.of(userId);
        Enrollment enrollment = Enrollment.of(enrollmentId, lectureId, userId);

        given(lectureRepository.findById(lectureId)).willReturn(Optional.of(lecture));
        given(userAccountRepository.findById(userId)).willReturn(Optional.of(userAccount));
        given(enrollmentRepository.save(any(Enrollment.class))).willReturn(enrollment);

        // when
        sut.applyLecture(requestDto);

        // then
        then(lectureRepository).should().findById(lectureId);
        then(userAccountRepository).should().findById(userId);

        ArgumentCaptor<Enrollment> enrollmentCaptor = ArgumentCaptor.forClass(Enrollment.class);
        then(enrollmentRepository).should().save(enrollmentCaptor.capture());
        Enrollment capturedEnrollment = enrollmentCaptor.getValue();

        assertThat(capturedEnrollment.getLectureId()).isEqualTo(lectureId);
        assertThat(capturedEnrollment.getUserId()).isEqualTo(userId);
    }

    @Test
    void given_when_then() {
        // given

        // when

        // then
    }

}