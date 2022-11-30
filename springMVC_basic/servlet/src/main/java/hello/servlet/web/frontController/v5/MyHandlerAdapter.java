package hello.servlet.web.frontController.v5;

import hello.servlet.web.frontController.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/30
 */
public interface MyHandlerAdapter {

    boolean supports(Object hadler);

    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
