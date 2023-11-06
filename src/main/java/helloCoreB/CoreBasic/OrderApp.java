package helloCoreB.CoreBasic;

import helloCoreB.CoreBasic.member.Grade;
import helloCoreB.CoreBasic.member.Member;
import helloCoreB.CoreBasic.member.MemberService;
import helloCoreB.CoreBasic.member.MemberServiceImpl;
import helloCoreB.CoreBasic.order.Order;
import helloCoreB.CoreBasic.order.OrderSerivceImpl;
import helloCoreB.CoreBasic.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderSerivceImpl();

        Long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("Order = " + order);
        System.out.println("Order.calculatePrice = " + order.calculatePrice());

    }
}
