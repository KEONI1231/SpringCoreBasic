package helloCoreB.CoreBasic.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    //프로그래밍의 대상은 구현체가 아닌 인터페이스에 맞춰야 한다.
    // 즉 코드는 가능한 구현보다는 인터페이스에 의존해야한다.
    // 이렇게 하면 구현이 변경되더라도 사용하는 쪽의 코드를 수정할 필요가 없어진다.
    //또한 나중에 MemoryMemberRepository를 다른 MemberRepository 의 구현으로 교체하고자 할 때,
    //MemberServiceImpl의 나머지 코드를 변경할 필요 없이 단지 새로운 구현 클래스를 인스턴스화하는 부분만
    //변경하면 된다.
    //AppConfig의 생성자를 통해서 할당. 즉 추상화에만 의존하게 됨.
    //생성자를 통해서 객체가 들어감. -> 생성자 주입.
    //MemberServiceImpl 입장에선 의존관계를 마치 외부에서 주입해주는 것 같다고 해서 DI, 의존성 주입이라고 함.


    //AutoWired
    //생성자에 autowired라는 어노테이션을 생성자에 붙여주면 생성자에 타입이 맞는 NenberRepository
    // 터압에 맞는 애를 찾아와서 의존관계 주입을 자동으로 찾아와서 주입해준다.
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {

        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {

        return memberRepository.findById(memberId);
    }

    //TEST
    public MemberRepository getMemberRepository() {

        return memberRepository;

    }
}
