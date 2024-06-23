package org.enrollment.lecture.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Enrollment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("수강일")
    private LocalDateTime enrolledAt;

    @ManyToOne
    private Lecture lecture;

    @ManyToOne
    private UserAccount userAccount;

    public Enrollment(Lecture lecture, UserAccount userAccount) {
        this.lecture = lecture;
        this.userAccount = userAccount;
    }

    public static Enrollment of(long lectureId, long userId) {
        return new Enrollment(Lecture.of(lectureId), UserAccount.of(userId));
    }

    @PrePersist
    void enrolledAt() {
        enrolledAt = LocalDateTime.now();
    }

}
