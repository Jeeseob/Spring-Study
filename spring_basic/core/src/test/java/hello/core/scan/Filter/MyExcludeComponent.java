package hello.core.scan.Filter;

import java.lang.annotation.*;

// Annotation
@Target(ElementType.TYPE) // Target 설정이 중요함, TYPE 은 클래스를 의미
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {


}
