package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    /**
     * @param member Member Class 객체
     * @param price Member가 주문한 물건 가격
     * @return 할인대상 금액
     */
    int discount(Member member, int price);
}
