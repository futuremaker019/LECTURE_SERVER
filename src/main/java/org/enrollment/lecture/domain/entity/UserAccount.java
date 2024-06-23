package org.enrollment.lecture.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(50) comment '사용자명'")
    private String username;

    @OneToMany
    private List<Enrollment> enrollments = new ArrayList<>();

    public UserAccount(Long id) {
        this.id = id;
    }

    public static UserAccount of(long userId) {
        return new UserAccount(userId);
    }
}