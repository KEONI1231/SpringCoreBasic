package helloCoreB.CoreBasic.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();
    // static 이라 되어있으면 STATIC 영역에 위에 하나만 올라감?

    public static  SingletonService getInstance() {
        return instance;
    }
    private SingletonService() {

    }
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
