package helloCoreB.CoreBasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreBasicApplication.class, args);
	}

}

/*
	회원
		1) 회원은 가입하고 조회할 수 있다.
		2) 회원은 일반과 vip 두가지 등급이있다.
		3) 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다.(미확정)

	주문과 할인 정책
		1) 회원은 상품을 주문할 수 있다.
		2) 회원 등급에 따라 할인 정책을 적용할 수 있다.
		3) 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라. (나중에 변경 될 수 있다.)
		할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전가지 고민을 미루고 싶다. 회악의 경우 할인을 적용하지 않을 수도 있다.
 */