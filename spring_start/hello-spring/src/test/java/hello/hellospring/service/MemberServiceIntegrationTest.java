package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest // 진짜 spring을 활용하여 test를 진행하게됨.
@Transactional // DB와 연결은 하지만, DB에 commit은 안하게됨. 즉 다음 테스트에 영향을 받지 않음. 테스트를 반복할 수 있음.
class MemberServiceIntegrationTest {

//    MemberService memberService;
//    MemoryMemberRepository memberRepository;
//
//    @BeforeEach
//    public void beforeEach() {
//        memberRepository = new MemoryMemberRepository();
//        memberService = new MemberService(memberRepository);
//    }

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService  memberService;
//
//    @AfterEach
//    public void afterEach() {
//        memberRepository.clearStore();
//    }
//    //ctrl + R 이전에 실행했던 파일 run

    @Test
    void join() {
        // given when then 문법 -> 주석을 달고 각 주석에 맞춰 개발하는 것

        //given - 해당하는 데이터를 기반으로 함
        Member member = new Member();
        member.setName("hello spring");

        //when - 어떤걸 검증하는지
        Long  saveId = memberService.join(member);

        //then - 결과가 이렇게 나와야함.
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    //test case에서는 method이름으로 한글도 사용한다고 함.
    public void 중복_회원_예외() {
        // test용 DB를 연결해서 실행 해야함.
        Member member1 = new Member();
        member1.setName("spring test");

        Member member2 = new Member();
        member2.setName("spring test");

        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member1));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}