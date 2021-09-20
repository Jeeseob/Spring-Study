package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;
    // data jpa 라이브러리를 받으면, spring boot가 알아서 EntityManager(DB connetion 정보 등 다 연결...)를 생성해줌.
    public JpaMemberRepository(EntityManager em) {
        this.em = em; //JPA를 사용하려면 EntityManager를 받아야함.
    }

    @Override
    public Member save(Member member) {
        em.persist(member); //영구 저장한다는 뜻
        return member;
    } // 이렇게 하면 member 다 넣어줌, Id까지 다 알아서 해줌...

    //PK로 검색할때,
    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id); // Id를 사용해서 검색
        return Optional.ofNullable(member); // NULL이 가능하다는 것.
    }

    //PK가 아닌 경우, 조회시 JPQL(일종의 SQL)필요하긴함. 하지만 기존 SQL이랑은 좀 다름.
    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // select 의 대상으로 객체 자체를 사용해서 select 가능
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
        // Ctrl + T 이후 검색 혹은 Cmd + Option + N => return 할 값을 바로 return 하는 형태로 바꿔줌.(한줄로)
    }
}
