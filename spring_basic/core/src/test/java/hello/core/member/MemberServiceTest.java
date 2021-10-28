package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    @Test
    void join(){
        //given - 이런게 주어졌을때,
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when - 이런 것을 실행하고,
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then - 결과적으로 이렇게 된다.
        //Assertions 선택할때, 바로 Tap하지말고 org.assertj.core.api사용
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
