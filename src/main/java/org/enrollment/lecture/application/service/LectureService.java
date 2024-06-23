package org.enrollment.lecture.application.service;

import org.enrollment.lecture.domain.dto.lecture.LectureRequestDto;

public interface LectureService {

    void applyLecture(LectureRequestDto requestDto);

}
