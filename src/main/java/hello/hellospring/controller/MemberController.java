package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // 스프링이 실행될때 자동으로 controller를 가져옴. jaba 코드로 Spring bean/Controller Service Repository  에서 둘다 사용되어야함.
public class MemberController {

    //이렇게 하면 새롭게 만들어야 함.
    //private final MemeberService memeberService = new MemberService();

    private final  MemberService memberService;

    @Autowired // Controller와 Service 연결. 의존관계 주입.
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm"; //memberes폴더의 createMemberForm.html로 간다.
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        // join 로직을 통해 memberservice로 들어감.

        return "redirect:/";
    }
    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members); //model을 통째로 넘긴다.
        return "/members/memberList";
    }
}
