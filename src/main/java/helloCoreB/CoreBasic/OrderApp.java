package helloCoreB.CoreBasic;

import helloCoreB.CoreBasic.member.Grade;
import helloCoreB.CoreBasic.member.Member;
import helloCoreB.CoreBasic.member.MemberService;
import helloCoreB.CoreBasic.order.Order;
import helloCoreB.CoreBasic.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//스프링 컨테이너의 장점?

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService
                .createOrder(memberId, "itemA", 20000);
        System.out.println("Order = " + order);
        System.out.println("Order.calculatePrice = " + order.calculatePrice());
    }
}
