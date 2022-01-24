package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;

public class PtototypeTest {

    @Test
    public void prototypeBeanTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean prototypeBean = ac.getBean(PrototypeBean.class);
        System.out.println("find PtototypeBean");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find PtototypeBean1");

        System.out.println("prototypeBean = " + prototypeBean);
        System.out.println("prototypeBean1 = " + prototypeBean1);

        Assertions.assertThat(prototypeBean).isNotSameAs(prototypeBean1);
        // 그때 그때 새로운 객체를 생성하기 때문에, 각 bean이 다른 것을 확인 할 수 있다.
        // close가 호출되지 않는 것 또한 알 수 있다.
        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean {

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
            System.out.println(LocalDateTime.now());
        }

        @PreDestroy
        public void close() {
            System.out.println("PrototypeBean.close");
        }
    }
}
