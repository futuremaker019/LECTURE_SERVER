package org.enrollment.lecture.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.enrollment.lecture.application.service.LectureService;
import org.enrollment.lecture.domain.dto.lecture.LectureRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LectureController.class)
@ExtendWith(SpringExtension.class)
class LectureControllerTest {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;

    @MockBean LectureService lectureService;

    @Test
    void 특강을_신청한다() throws Exception {
        // given
        long lectureId = 1L;
        long userId = 1L;

        LectureRequestDto requestDto = LectureRequestDto.of(lectureId, userId);
        willDoNothing().given(lectureService).applyLecture(requestDto);

        // when
        mockMvc.perform(post("/api/lectures/apply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(LectureRequestDto.of(lectureId, userId)))
                )
                .andDo(print())
                .andExpect(status().isOk());

        // then
        then(lectureService).should().applyLecture(requestDto);
    }

}