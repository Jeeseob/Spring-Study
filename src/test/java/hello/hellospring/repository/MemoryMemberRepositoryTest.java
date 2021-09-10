package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.OptionalAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

// TestClass의 이름은 classNameTest로 만든다.
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //test method가 끝나고 실행됨.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    //Test를 한다고 보면 됨.
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //두가지 방법으로 실행 가능. memeber와 result가 다르면 문제 발생.

        //Assertions.assertEquals(member, result);

        // Assertions.에서 option+Enter한 후 나오는 창에서 static import 하면 생략 가능.
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        // 데이터 복사 후 shift+F6을 누르면 이름 변경 가능. -> 한번에 변경됨.
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test

    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
