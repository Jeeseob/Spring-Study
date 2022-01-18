package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// @RequiredArgsConstructor // Lombok 적용
public class OrderServiceImpl implements OrderService{

    // 여기서 구현체만 변경하면, 다른 구현체도 사용 가능.
    // 좋은 방식은 아님...
    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 택 1
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();



//    // 수정자 의존관계 주입 테스트
//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy;
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discoun≤tPolicy;
//    }
//    // 여기 까지 테스트


    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    // Lombok 적용 - 생성자 자동 생성


    // 최적화
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
    //public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("rateDiscountPolicy")DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원 정보 조회 + 할인 금액 확인
        Member member = memberRepository.findById(memberId);
        // member자체를 넘기는 이유는, 이후 확장성을 위해서
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
