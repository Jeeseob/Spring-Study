package hello.servlet.web.frontController.v3;

import hello.servlet.web.frontController.ModelView;

import java.util.Map;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/17
 */
public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
