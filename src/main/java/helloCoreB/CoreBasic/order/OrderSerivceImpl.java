package helloCoreB.CoreBasic.order;

import helloCoreB.CoreBasic.discount.DiscountPolicy;
import helloCoreB.CoreBasic.member.Member;
import helloCoreB.CoreBasic.member.MemberRepository;
import helloCoreB.CoreBasic.member.MemoryMemberRepository;

public class OrderSerivceImpl implements OrderService
{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
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
     */
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
