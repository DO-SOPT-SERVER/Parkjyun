package org.sopt.www.Seminar.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    public int getHttpStatusCode() {
        return this.errorMessage.getHttpStatusValue();
    }

}
