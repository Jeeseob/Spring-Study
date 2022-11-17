package hello.servlet.web.frontController.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.v3.ControllerV3;

import java.util.Map;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/17
 */
public class MemberSaveControllerV3 implements ControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        Member savedMember = memberRepository.save(member);

        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", savedMember);
        return modelView;
    }
}
