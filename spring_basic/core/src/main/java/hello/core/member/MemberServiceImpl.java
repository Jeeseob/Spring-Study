package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // Memory Member Repostory가 override되서 나온다ㅏ.
    // DIP위반 -> new MemoryMemberRepository()부분에서 구현체에 의존하게 된다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
