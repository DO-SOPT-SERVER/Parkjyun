package org.sopt.www.Seminar.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessMessage {

    GET_MEMBER_SUCCESS(HttpStatus.OK, "멤버 조회에 성공하였습니다"),
    GET_POST_SUCCESS(HttpStatus.OK, "게시글 조회에 성공하였습니다"),

    CREATE_MEMBER_SUCCESS(HttpStatus.CREATED, "멤버 생성에 성공하였습니다."),
    CREATE_POST_SUCCESS(HttpStatus.CREATED, "게시글 생성에 성공하였습니다."),
    UPDATE_MEMBER_SUCCESS(HttpStatus.OK, "멤버 업데이트에 성공하였습니다"),
    DELETE_MEMBER_SUCEESS(HttpStatus.OK, "멤버 삭제에 성공하였습니다");

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusValue() {
        return httpStatus.value();
    }

    public String getMessage() {
        return message;
    }

}
