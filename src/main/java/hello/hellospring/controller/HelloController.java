package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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

    @GetMapping("hello-string")
    @ResponseBody // client로 return 값을 직접 넘기겠다는 의미.
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name; // 여기서 return 된 값이 바로 client로 보내짐. (html 코드 아님)
        // 의미 없음. 이런식으로는 거의 사용 X
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // = {"name" : "value"}객체를 return 함. (json)
        // spring은 기본으로 json으로 전송되도록 설정되어 있음.
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        // java been 표준 방식 (property 접근 방식) getter, setter -> 검색해서 찾아보고 공부할 것.
        // private String name; 만 있는 상태에서 (ctrl + enter) 누르고 getter,setter누르면 자동완성 됨.
    }
}
