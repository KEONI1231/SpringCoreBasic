package helloCoreB.CoreBasic.scan;

import helloCoreB.CoreBasic.AutoAppConfig;
import helloCoreB.CoreBasic.member.MemberRepository;
import helloCoreB.CoreBasic.member.MemberService;
import helloCoreB.CoreBasic.order.OrderServiceImpl;
import net.bytebuddy.description.annotation.AnnotationDescription;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService ).isInstanceOf(MemberService.class);

        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = bean.getMemberRepository();
        System.out.println("memberRepository = " + memberRepository);

    }

}
