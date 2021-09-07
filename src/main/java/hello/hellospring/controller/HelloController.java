package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String heloMvc(@RequestParam(name = "name", required = true) String name, Model model) {
        // RequestParm 에서 name을 파라미터로 받는다.
        // 방법은 url/hello-mvc?name='값'이다.
        model.addAttribute("name", name);
        return "hello-template";
    }
}
