package org.enrollment.lecture.application.controller;

import lombok.RequiredArgsConstructor;
import org.enrollment.lecture.application.service.LectureService;
import org.enrollment.lecture.domain.dto.lecture.LectureRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lectures")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    // 특강신청
    @PostMapping("/apply")
    public ResponseEntity<String> enrollLecture(@RequestBody LectureRequestDto requestDto) {
        lectureService.applyLecture(requestDto);
        return ResponseEntity.ok().body("hello");
    }

    // 신청된 특강들 확인
    @GetMapping
    public ResponseEntity<String> selectEnrolledLectureList() {
        return ResponseEntity.ok().body("hello");
    }

}
