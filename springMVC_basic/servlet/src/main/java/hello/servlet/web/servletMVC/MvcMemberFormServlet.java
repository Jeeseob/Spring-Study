package hello.servlet.web.servletMVC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/16
 * MVC 중 Controller
 */
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";    // WEB-INF 디렉토리에 있는 jsp파일의 경우, servlet을 거쳐야 접근이 가능하다. url로 접근 불가. WAS 규칙
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);  // 다른 서블릿이나 JSP로 이동할 수 있는 기능, 서버 내부에서 다시 호출됨.(redirect 발생 없음)
        // redirect는 클라이언트에서 해당 경로로 다시 요청 -> client가 2번 호출, forward는 서버 내부에서 호출 -> client입장에선 한번만 요청
    }
}
