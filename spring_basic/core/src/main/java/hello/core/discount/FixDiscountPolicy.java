package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // 조회되는 빈이 2개인 경우 - 문제
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        else {
            return 0;
        }
    }
}
