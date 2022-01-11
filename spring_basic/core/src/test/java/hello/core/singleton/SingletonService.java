package hello.core.singleton;

public class SingletonService {
    // static으로 설정
    private static final SingletonService instance = new SingletonService();

    // 처음 생성 시, 자기 자신의 객체를 만들어서 보냄
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {} // 여러개의 SingletonService가 생성되지 않도록 제한

    public void logic() {
        System.out.println("싱글톤 로직 실행");
    }

}
