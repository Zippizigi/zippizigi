package zipizigi.backend.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zipizigi.backend.Entity.Member;
import zipizigi.backend.Repository.MemberRepository;

/**
 * 테스트
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final MemberRepository memberRepository;

    /**
     * 테스트 회원 저장
     * @return
     */
    @PostMapping("/saveMember")
    public String saveMember() {
        Member tester = Member.builder()
                .memberName("강수나")
                .build();

        memberRepository.save(tester);
        return "회원 정보 저장 완료";
    }

    /**
     * 테스트 회원 조회
     * @return
     */
    @GetMapping("/getMember")
    public String getMember() throws Exception {
        try{
            Member tester = memberRepository.findByMemberId(1L);
            log.info("조회된 회원 => id: {}, name: {}", tester.getMemberId(), tester.getMemberName());
        } catch (NullPointerException e) {
            log.error(e.getMessage());
            throw new NullPointerException();
        }
        return "회원 정보 조회 완료";
    }
}
