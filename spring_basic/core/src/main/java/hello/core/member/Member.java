package hello.core.member;

public class Member {
    // Database와 연동되다 보면, Null값이 들어갈 수도 있기 때문에 long이 아니라 Long 사용
    // 일반적으로는 id값이라 그럴 일은 없을듯
    private Long id;
    private String name;
    private Grade grade;

    //commend + N Constructor 자동완성
    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
