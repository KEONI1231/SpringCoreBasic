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


//
@Configuration
public class AppConfig {

    // AppConfig -> 설정 정보, 구성정보 담당엔 @Configration
    // 메서드엔 Bean -> 스프링 컨테이너에 등록됨
    // 스프링 컨테이너를 쓰면 객체를 싱글톤 형태로 만들어서 관리해준다.
    /*
        @Bean memberService -> new MemoryMemberRepository()
        @Bean orderService -> new MemoryMemberRepository();

        [ 예상 ]
        //call AppConfig.memberService
        //call AppConfig.memberRepository
        //call AppConfig.memberRepository
        //call AppConfig.orderService
        //call AppConfig.memberRepository

        [ 실제 호출 ]
        //call AppConfig.memberService
        //call AppConfig.memberRepository
        //call AppConfig.orderService

     */
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());

    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );

//        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();

        return new RateDiscountPolicy();
    }
}
