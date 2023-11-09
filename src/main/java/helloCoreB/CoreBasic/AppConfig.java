package helloCoreB.CoreBasic;

import helloCoreB.CoreBasic.discount.DiscountPolicy;
import helloCoreB.CoreBasic.discount.RateDiscountPolicy;
import helloCoreB.CoreBasic.member.MemberService;
import helloCoreB.CoreBasic.member.MemberServiceImpl;
import helloCoreB.CoreBasic.member.MemoryMemberRepository;
import helloCoreB.CoreBasic.order.OrderServiceImpl;
import helloCoreB.CoreBasic.order.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    // AppConfig -> 설정 정보, 구성정보 담당엔 @Configration
    // 메서드엔 Bean -> 스프링 컨테이너에 등록됨
    @Bean
    public MemberService memberService() {

        return new MemberServiceImpl(memberRepository());

    }
    @Bean
    public MemoryMemberRepository memberRepository() {

        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
