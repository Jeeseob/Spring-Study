package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/16
 *
 * 동시성 문제가 고려되어 있지 않은 예제이다.
 * 실무에서는 ConcurrentHashMap, AtomicLong 등의 사용을 고려해야 한다.
 */
public class MemberRepository {
    private static final Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    // 싱글톤 패턴 적용
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }
    private MemberRepository() {}

    public Member save(Member member) {
        member.setId(++this.sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
