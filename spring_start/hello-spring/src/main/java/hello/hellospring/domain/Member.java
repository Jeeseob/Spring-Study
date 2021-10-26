package hello.hellospring.domain;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 PK를 알아서 생성.
    private Long id;

    //@Column(name = 'username') //변수 명과 column명이 다른 경우 이렇게 활용가능.
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
