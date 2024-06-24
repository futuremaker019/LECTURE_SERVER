package org.enrollment.lecture.domain.dto.lecture;

import org.enrollment.lecture.domain.entity.Enrollment;
import org.enrollment.lecture.domain.entity.Lecture;
import org.enrollment.lecture.domain.entity.UserAccount;

public record LectureRequestDto(long lectureId, long userId) {

    public static LectureRequestDto of(long lectureId, long userId) {
        return new LectureRequestDto(lectureId, userId);
    }

    public Enrollment enroll() {
        return Enrollment.of(this.lectureId, this.userId);
    }

}
