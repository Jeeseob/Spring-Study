package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

//TestCase만들때 cmd + shift + T 누른 후 test할 method들 선택하면 바로 만들어짐.
public class MemberService {

    private final MemberRepository memberRepository;
    // cmd + N -> 아래처럼 외부에서 불러오도록 만들 수 있음.
    // 아래 코드는 객체를 직접 만드는 것이 아니라 외부에서 넣어주는 것이라고 함.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     *  회원가입
     */
    public Long join(Member member) {
        //같은 이름이 있는지 확인
        // cmd + option + V
        // 들어갈 값(여기서는 memberRepository...)을 입력한 후 누르면, 앞에 return 되는 type 자동으로 적어줌.
        //Optional<Member> result = memberRepository.findByName(member.getName());
        /**
         * result.ifPresent(m -> {
         * throw new IllegalStateException("이미 존재하는 회원입니다.");
         * });
        */
        // ifPresent -> 값이 존재한다면, Optional로 감싸면 해당 method들을 사용하기 때문에
        // Null일 가능성이 있다면, Optional로 감싸는게 좋음.(여러 method 사용가능)
        // 직접 값을 꺼내서 null인지 확인하는 것은 비추천.

        //위의 코드에서 result를 굳이 사용하지 않고 하는 방법. 이미 return 값이 Optrioinal이라서 가능

        // ctrl + T 는 리팩토링 관련 명령어가 많이 나옴.
        // 여기서 Extract Method를 누르면 알아서 함수로 변환해줌.
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m-> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    /**
     * 전체 회원 조회
     */

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
