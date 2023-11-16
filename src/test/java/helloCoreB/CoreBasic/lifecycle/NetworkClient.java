package helloCoreB.CoreBasic.lifecycle;


//@PostConstruct ->  생성이 된 이후에
//@PreDestroy -> 소멸되기 전에

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, Url = " + url);
//        connect();
//        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }
    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect: "+url);
    }

    public void call (String message) {
        System.out.println("call : " + url + " message = "+ message);

    }
    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close "+url);
    }

    @PostConstruct
    public void init() throws Exception {
        //의존관계 주입이 긑나면 호출해주겠다.
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }
    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}

//빈 스코프란?
/*
    스프링 빈이 스프링컨테이너가 생성이 될때 빈들도 함께 생성되고 관리되고, 스프링이 종료되기 직전에 종료됨.
    스프링 빈이 기본적으로 싱글톤 스코프로 생성되기 때문.

    기본 스코프 : 스프링 컨테이너의 시작과 종료까지 유지되는 가장 넓은 범위의 스코프이다.
    싱글톤 : 기본 스코프, 스프링 컨테이너는 프로토타입 빈의 생성과 의존과계 주입까지만 관여하고 더는 관리하지 않는 매우 짧은 범위의 스코프이다.
    프로토타입 : 스프링 컨테이너는 프로토타입 빈의 생성과 의존과계 주입가지만 관여하고 더는 관리하지 않는 매우 짧은 범위의 스코프.

    웹관련 스코프
        - request : 웹 요청이 들어오고 나갈때까지 유지되는 스코프이다.
        - session : 웹 세션이 생성되고 종료될때까지 유지되는 스코프이다.
        - application : 웹의 서블릿 컨텍스와 같은 범위로 유지되는 스코프이다.

 */
