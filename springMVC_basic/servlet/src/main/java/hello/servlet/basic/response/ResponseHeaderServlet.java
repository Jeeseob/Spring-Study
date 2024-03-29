package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/16
 */
@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  [status-line]
        response.setStatus(HttpServletResponse.SC_OK);

        // [response-headers]
        // response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // Cache를 완전히 무효화
        response.setHeader("Pragma", "no-cache");   // 과거 버젼 Cache까지 제거
        response.setHeader("my-header", "hello");   // Custom Header(임의로 추가)

        // [Header 편의 메소드]
        content(response);
        cookie(response);
        redirect(response);

        response.getWriter().println("한국어 테스트");
    }

    private void content(HttpServletResponse response) {
        // Content-Type: text/plain; charset=utf-8
        // Content-Length: 2
//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
//        response.setContentLength(2);   // 생략시, 자동 계산
    }

    private void cookie(HttpServletResponse response) {
        // Set-Cookie: myCookie=good; Max-Age=600
//        response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        // Status Code 302
        // Location: /basic/hello-form.html,
//        response.setStatus(HttpServletResponse.SC_FOUND);
//        response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("basic/hello-form.html"); // 해당 주소로 redirect (status code는 302)
    }
}
