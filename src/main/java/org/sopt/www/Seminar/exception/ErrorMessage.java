package org.sopt.www.Seminar.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorMessage {

    // 400 BAD REQUEST
    REQUEST_VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다"),

    //404 NOT FOUND
    MEMBER_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "멤버가 없습니다"),
    POST_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "게시글이 없습니다");



    private HttpStatus httpStatus;
    private String message;

    public int getHttpStatusValue() {
        return httpStatus.value();
    }

    public String getMessage() {
        return message;
    }
}
