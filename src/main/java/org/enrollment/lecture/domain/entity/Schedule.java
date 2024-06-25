package org.enrollment.lecture.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("특강 id")
    private Long lectureId;

    @Comment("수강가능한 사람수")
    private Integer userLimit;

    @Comment("개강일")
    private LocalDateTime openedAt;

    @PrePersist
    public void openedAt() {
        openedAt = LocalDateTime.now();
    }

}
