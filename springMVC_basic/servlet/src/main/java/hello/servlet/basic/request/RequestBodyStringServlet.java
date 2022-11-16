package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/16
 *
 * HTTP API (using Request Body)
 * POST, PUT, PATCH에 사용
 * 주로 JSON
 */
@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();  // InputStream은 ByteCode를 반환한다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);// Byte to String시에는 인코딩 정보를 추가해야한다.

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");
    }
}
