package helloCoreB.CoreBasic;

import helloCoreB.CoreBasic.discount.FixDiscountPolicy;
import helloCoreB.CoreBasic.member.MemberService;
import helloCoreB.CoreBasic.member.MemberServiceImpl;
import helloCoreB.CoreBasic.member.MemoryMemberRepository;
import helloCoreB.CoreBasic.order.OrderSerivceImpl;
import helloCoreB.CoreBasic.order.OrderService;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    public OrderService orderService() {
        return new OrderSerivceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
