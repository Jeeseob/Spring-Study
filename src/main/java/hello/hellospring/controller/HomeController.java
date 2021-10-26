package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // index.html(static) 보다 우선순위가 먼저임.
    // Controller 우선.
    @GetMapping("/") // 도메인으로 들어오면 바로 이게 실행됨.
    public String home() {
        return "home";
    }

}
