package helloCoreB.CoreBasic.discount;

import helloCoreB.CoreBasic.member.Grade;
import helloCoreB.CoreBasic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;
    @Override
    public int discount(Member membert, int price) {
        if(membert.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        else {
            return 0;
        }
    }
}
