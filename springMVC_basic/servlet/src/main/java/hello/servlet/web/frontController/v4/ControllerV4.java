package hello.servlet.web.frontController.v4;

import java.util.Map;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/30
 */
public interface ControllerV4 {

    /**
     * @param paramMap
     * @param model
     * @return viewName
     */
    String process(Map<String, String> paramMap, Map<String, Object>model);
}
