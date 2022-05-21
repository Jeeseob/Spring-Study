package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/05/20
 */

@Service
@RequiredArgsConstructor
public class LogDemoService {

    // 해당 함수를 사용할때만, bean을 새로 주입한다.(사람마다 다를때 이렇게 처리하면 된다.)
    // private final ObjectProvider<MyLogger> myLoggerProvider;

    private final MyLogger myLogger;
    public void logic(String testId) {
       // MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + testId);
    }
}
