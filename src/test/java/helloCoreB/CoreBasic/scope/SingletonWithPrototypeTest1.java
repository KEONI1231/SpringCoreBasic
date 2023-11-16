package helloCoreB.CoreBasic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);



    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;

        }
        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init = " +  this);
        }
        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }

    }


}

