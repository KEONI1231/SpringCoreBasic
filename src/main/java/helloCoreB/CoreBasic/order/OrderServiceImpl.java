package helloCoreB.CoreBasic.order;

import helloCoreB.CoreBasic.discount.DiscountPolicy;
import helloCoreB.CoreBasic.member.Member;
import helloCoreB.CoreBasic.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService
{
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private  DiscountPolicy discountPolicy;

     private final  MemberRepository memberRepository;
     private final DiscountPolicy discountPolicy;


    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    /*
        [ 현재 의존 관계 ]
            OrderServiceImple은 DiscountPolicy에 의존하고있다.
            뿐만 아니라, FixDiscountPolicy와 RateDiscountPolicy에도 의존하고 있다.
            --> Dip위반. 의존 관계 1) 구체에 의존하지 말고 추상화에 의존해라.

            그래서 FixDiscountPolicy를 RateDiscountPolicy로 변경하는 순간
            OrderServiceImpl의 소스코드도 변경해야 한다.
            Ocp위반

        [ 해결법 ]
            OrderServiceImpl이 DiscountPolicy에도 의존하도록 변경
            Dip를 위반하지 않도록 인터페이스에만 의존하도록 의존관계를 변경하면 된다.
            private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
            를
            private DiscountPolicy discountPolicy;
            물론 interface만 가지고 실행할수 없기때문에 이 상태에서 코드를 실행하면 널포인트이쎕션발생
            OrderServiceImpl에 DiscountPolicy의 구현객체를 대신 생성하고 주입해주어야 한다.
            AppConfig의 생성자를 통해서 할당. 즉 추상화에만 의존하게 됨.
            생성자를 통해서 객체가 들어감. -> 생성자 주입.
            MemberServiceImpl 입장에선 의존관계를 마치 외부에서 주입해주는 것 같다고 해서 DI, 의존성 주입이라고 함.
     */
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,
                            DiscountPolicy discountPolicy) {
        System.out.println("memberRepository = " + memberRepository);
        System.out.println("discountPolicy  = " + discountPolicy);
        this.memberRepository = memberRepository; //어떤 저장소에 저장할건지
        this.discountPolicy  = discountPolicy; //어떤 할인 정책을 적용할건지
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {

        return memberRepository;

    }

}

