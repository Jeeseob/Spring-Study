package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


// @ComponentScan --> @Componet어노테이션이 붙어있는 클래스를 자동으로 스프링 빈으로 등록한다.
@Configuration
@ComponentScan(
        // @Configuration도 ComponentScan에서 Scan되기 때문에, AppConfig도 등록되게 된다. 때문에 예제에서는 해당 부분을 제외한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

// @Autowired를 활용하면, 자동으로 스프링 빈의 의존관계를 만들어줌

}
