package org.sopt.www.Seminar.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.www.Seminar.exception.ErrorMessage;
import org.sopt.www.Seminar.exception.SuccessMessage;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ApiResponse<T> {
    private final int code;
    private final String message;
    private T data;

    public static ApiResponse success(SuccessMessage success) {
        return new ApiResponse(success.getHttpStatusValue(), success.getMessage());
    }

    public static <T> ApiResponse<T> success(SuccessMessage success, T data) {
        return new ApiResponse<T>(success.getHttpStatusValue(), success.getMessage(), data);
    }

    public static ApiResponse error(ErrorMessage error) {
        return new ApiResponse(error.getHttpStatusValue(), error.getMessage());


    }
}
