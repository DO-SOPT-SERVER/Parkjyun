package org.sopt.www.Seminar.dto.health;

import lombok.Getter;

@Getter
public class HealthCheckResponse {
    private static final String STATUS = "OK";
    private String status;


    public HealthCheckResponse(
    ) {
        this.status = STATUS;
    }
}
