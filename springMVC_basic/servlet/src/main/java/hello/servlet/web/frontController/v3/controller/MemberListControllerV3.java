package hello.servlet.web.frontController.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.v3.ControllerV3;

import java.util.List;
import java.util.Map;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/17
 */
public class MemberListControllerV3 implements ControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelView modelView = new ModelView("members");
        modelView.getModel().put("members", members);

        return modelView;
    }
}
