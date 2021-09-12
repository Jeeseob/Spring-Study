package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 스프링이 실행될때 자동으로 controller를 가져옴.
public class MemberController {

    //이렇게 하면 새롭게 만들어야 함.
    //private final MemeberService memeberService = new MemberService();

    private final  MemberService memberService;

    @Autowired // Controller와 Service 연결. 의존관계 주입.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
