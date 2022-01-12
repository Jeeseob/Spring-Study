package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // Memory Member Repostory가 override되서 나온다ㅏ.
    // DIP위반 -> new MemoryMemberRepository()부분에서 구현체에 의존하게 된다.
    private final MemberRepository memberRepository;

    // 의존관계 자동 주
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    // Test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
