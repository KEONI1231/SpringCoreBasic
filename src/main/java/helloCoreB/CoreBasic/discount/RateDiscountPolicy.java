package helloCoreB.CoreBasic.discount;

import helloCoreB.CoreBasic.annotation.MainDiscountPolicy;
import helloCoreB.CoreBasic.member.Grade;
import helloCoreB.CoreBasic.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
//@Primary
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent  = 10;//%

    @Override
    public int discount(Member membert, int price) {
        if(membert.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
