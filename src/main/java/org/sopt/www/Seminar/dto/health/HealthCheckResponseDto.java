package org.sopt.www.Seminar.dto.health;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)//staticname = 'of'
//@Data(staticConstructor = 'of') -> 정적팩토리 메서드 of를 자동으로 생성해줌
public class HealthCheckResponseDto {
    int code;
    String status;
    boolean success;

    public static HealthCheckResponseDto success(HttpStatus status) {
        return new HealthCheckResponseDto(status.value(), status.name(), true);
    }

}
