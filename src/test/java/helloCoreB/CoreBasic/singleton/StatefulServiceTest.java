package helloCoreB.CoreBasic.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //Threadb: A사용자 10000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //Thread A :사용자 A가 주문 금액을 조회합니다.
        //int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);
        // 출력은 20000원이 나옴. 유저 a를 조회했지만, b에 의해 덮어짐.

        //org.assertj.core.api.Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }
    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}