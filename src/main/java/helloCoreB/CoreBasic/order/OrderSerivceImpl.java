package helloCoreB.CoreBasic.order;

import helloCoreB.CoreBasic.discount.DiscountPolicy;
import helloCoreB.CoreBasic.discount.FixDiscountPolicy;
import helloCoreB.CoreBasic.member.Member;
import helloCoreB.CoreBasic.member.MemberRepository;
import helloCoreB.CoreBasic.member.MemoryMemberRepository;

public class OrderSerivceImpl implements OrderService
{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
