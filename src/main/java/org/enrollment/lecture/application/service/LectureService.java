package org.enrollment.lecture.application.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.enrollment.lecture.domain.dto.lecture.LectureRequestDto;
import org.enrollment.lecture.domain.entity.Enrollment;
import org.enrollment.lecture.domain.entity.Lecture;
import org.enrollment.lecture.domain.entity.UserAccount;
import org.enrollment.lecture.infra.repository.enrollment.EnrollmentRepository;
import org.enrollment.lecture.infra.repository.lecture.LectureRepository;
import org.enrollment.lecture.infra.repository.userAccount.UserAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;
    private final UserAccountRepository userAccountRepository;
    private final EnrollmentRepository enrollmentRepository;

    public void applyLecture(LectureRequestDto requestDto) {
        // findById 로 두 객체를 모두 찾는다.
        Lecture lecture = lectureRepository.findById(requestDto.lectureId()).orElseThrow(
                () -> new EntityNotFoundException("lecture not found : id - %d".formatted(requestDto.lectureId())));
        UserAccount userAccount = userAccountRepository.findById(requestDto.userId()).orElseThrow(
                () -> new EntityNotFoundException("userAccount not found : id - %d".formatted(requestDto.userId())));

        enrollmentRepository.save(Enrollment.of(lecture.getId(), userAccount.getId()));

        /**
         *  특강 신청 히스토리
         *      - 특강 선청 테이블과 데이터가 많이 겹친다.
         *      - 어떤식으로 표현해줘야하나
         */
    }



}
