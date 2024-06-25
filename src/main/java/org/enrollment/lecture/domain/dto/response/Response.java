package org.enrollment.lecture.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    private String resultCode;
    private T data;

    public static <T> Response<T> success() {
        return new Response<T>("SUCCESS", null);
    }

}
