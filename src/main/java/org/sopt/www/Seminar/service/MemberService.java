package org.sopt.www.Seminar.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sopt.www.Seminar.domain.Member;
import org.sopt.www.Seminar.dto.request.MemberCreateRequest;
import org.sopt.www.Seminar.dto.response.MemberGetResponse;
import org.sopt.www.Seminar.repository.MemberJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor//생성자 하나면 autowired 자동으로 붙음
@Transactional(readOnly = true)
public class MemberService {
    private final MemberJpaRepository memberJpaRepository;
    
    public MemberGetResponse getByIdV1(Long memberId) {//무지성 get은 좋은 방법이 아니다
        Member member = memberJpaRepository.findById(memberId).get();//만약 memberid에 해당하는 멤버가 없어도 무지성으로 땡겨와라 -> nullpointer exception발생할 수도
        MemberGetResponse response = MemberGetResponse.of(member);
        return response;
    }

    public MemberGetResponse getByIdV2(Long memberId) {
//        Member member = memberJpaRepository.findById(memberId)//findbyid의 returntype은 optional-> 존재할수도 존재하지 않을수도 -> 만약존재하지 않으면 null이 반환됨
//                .orElseThrow( () -> new EntityNotFoundException("해당하는 회원이 없습니다."));//만약 조회가 안된다면 예외를 던져라
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(memberId));
    }

    private Member findById(Long memberId) {
        return memberJpaRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("해당하는 회원이 없습니다")
        );
    }

    public List<MemberGetResponse> getMembers() {
        return memberJpaRepository.findAll()
                .stream()////조회가 된 멤버에 대해 각각 매핑을 해주겠다
                .map(MemberGetResponse::of)//조회된 멤버들을 membergetResponse로 만들어라
                //.map(member -> MemberGetResponse.of(member))위는 이것과 같은 의미임
                        .collect(Collectors.toList());

    }

    @Transactional//클래스와 매소드에 모두 transactional 붙일 수 있는데 더 구체적인 것(메서드)에 붙은 것이 우선권을 가져감
    public String create(MemberCreateRequest request) {//여기리팩토링하기 membercreaterequest를 record로
        Member member = Member.builder()
                .name(request.name())//request.getName과 동일
                .nickname(request.nickname())
                .age(request.age())
                .sopt(request.soptInfo())
                .build();
        return memberJpaRepository.save(member).getId().toString();//디비에 저장하고 저장한놈 아이디 갖고와서 문자로 갖고와서 URI로 만들어주기
    }
}
