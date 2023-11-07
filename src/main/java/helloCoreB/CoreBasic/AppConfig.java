package helloCoreB.CoreBasic;

import helloCoreB.CoreBasic.discount.DiscountPolicy;
import helloCoreB.CoreBasic.discount.FixDiscountPolicy;
import helloCoreB.CoreBasic.discount.RateDiscountPolicy;
import helloCoreB.CoreBasic.member.MemberService;
import helloCoreB.CoreBasic.member.MemberServiceImpl;
import helloCoreB.CoreBasic.member.MemoryMemberRepository;
import helloCoreB.CoreBasic.order.OrderSerivceImpl;
import helloCoreB.CoreBasic.order.OrderService;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderSerivceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
