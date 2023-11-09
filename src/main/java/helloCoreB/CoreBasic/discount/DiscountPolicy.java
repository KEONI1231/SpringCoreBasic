package helloCoreB.CoreBasic.discount;

import helloCoreB.CoreBasic.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member membert, int price);
}

