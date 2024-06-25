package org.enrollment.lecture.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(50) comment '강의명'")
    private String name;

    @Comment("개강일")
    private LocalDate openedAt;

    @PrePersist
    public void openedAt() {
        this.openedAt = LocalDate.now();
    }

    public Lecture(Long id) {
        this.id = id;
    }

    public static Lecture of(long lectureId) {
        return new Lecture(lectureId);
    }
}
