package org.enrollment.lecture.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.enrollment.lecture.application.service.LectureService;
import org.enrollment.lecture.domain.dto.lecture.LectureRequestDto;
import org.enrollment.lecture.infra.repository.enrollment.EnrollmentRepository;
import org.enrollment.lecture.infra.repository.lecture.LectureRepository;
import org.enrollment.lecture.infra.repository.userAccount.UserAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;
    private final UserAccountRepository userAccountRepository;
    private final EnrollmentRepository enrollmentRepository;

    @Override
    public void applyLecture(LectureRequestDto requestDto) {
        // findById 로 두 객체를 모두 찾는다.

//        enrollmentRepository.save();
    }

}
