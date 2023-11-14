package helloCoreB.CoreBasic.autowired;

import helloCoreB.CoreBasic.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }
    static class TestBean {
        @Autowired(required = false) //의존 관계가 없으면 이 메서드 호출 자체가 안된다.
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2); //널러블을 넣으면 호출은 되지만 널이 들어옴

        }
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = "+ noBean3); //널이면 엠티라는 값이 넘어온다.
        }
    }
}
