package hello.core.member;

public interface MemberRepository {
    //회원을 저장하는 함수
    void save(Member member);
    // 회원을 Id를 기반으로 찾는 함수
    Member findById(Long MemberId);
}
