package org.sopt.www.seminar.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.www.seminar.dto.request.MemberCreateRequest;
import org.sopt.www.seminar.dto.response.MemberGetResponse;
import org.sopt.www.seminar.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor//생성자 주입
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{id}")
    public ResponseEntity<MemberGetResponse> getMemberProfileV1(@PathVariable("id") Long memberId) {
        return ResponseEntity.ok(memberService.getByIdV1(memberId));
    }

    @GetMapping(value = "/{memberId}/v2", produces = MediaType.APPLICATION_JSON_VALUE)//Return으로 json을 준다
    public ResponseEntity<MemberGetResponse> getMemberProfileV2(@PathVariable Long memberId) {//@pathvariable은 {memberId}를 받아올 수 있는 annotation
        return ResponseEntity.ok(memberService.getByIdV2(memberId));
    }

    @GetMapping
    public ResponseEntity<List<MemberGetResponse>> getMembersProfile() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    @PostMapping//멤버 생성 후 따로 리턴 뭐 안해도 되자나~//requestbody 리퀘스트의 바디내용을 자바 객체로 갖고옴
    public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequest request) {
        URI location = URI.create("api/member" + memberService.create(request)) ;//만약 멤버 아이디가 2라면 location은 숫자 2
        return ResponseEntity.created(location).build();//location이 헤더로 날라감.
    }
}
