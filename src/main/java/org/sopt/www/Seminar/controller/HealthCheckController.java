package org.sopt.www.Seminar.controller;


import org.sopt.www.Seminar.dto.response.HealthCheckResponse;
import org.sopt.www.Seminar.dto.response.HealthCheckResponseDto;
import org.sopt.www.Seminar.sample.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController//controller + responsebody==자바 객체를 http응답바디로 매팡//controller에 component가 붙어있어 spring bean으로 관리됨
@RequestMapping("/health")
public class HealthCheckController {
    @GetMapping("/v1")//bad//getmapping 안에도 requestmapping이 있어서 /health/v1으로 이어진다.
    public Map<String, String> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return response;
    }

    @GetMapping("/v2")
    public ResponseEntity<String> healthCheckV2() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/v3")
    public String healthCheckV3() {//집가서 sample package지우기
        Person person = Person.builder()//어떤 파라미터에 어떤 값이 들어갔는지 직관적으로 확인 가능 파라미터의 종류가 많을 떄 활용//생성자의 매개변수 중 일부만을 사용해도 됨.
                .lastName("박")
                .firstName("재연")
                .build();

        return person.getFirstName();

    }

    @GetMapping("/v4")//bad
    public ResponseEntity<Map<String,String>> healthCheckV4() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v5")//dto
    public ResponseEntity<HealthCheckResponse> healthCheckV5() {//generic안의 자료형은 내 response의 자료형

        return ResponseEntity.ok(new HealthCheckResponse());//reponseentity.ok는 status 200 안의 데이터는 200으로 하겠다.
    }

    @GetMapping("/v6")
    public HealthCheckResponseDto healthCheckV6() {

        return HealthCheckResponseDto.success(HttpStatus.OK);
    }


}
