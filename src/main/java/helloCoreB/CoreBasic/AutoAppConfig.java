package helloCoreB.CoreBasic;


import helloCoreB.CoreBasic.member.MemberRepository;
import helloCoreB.CoreBasic.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


// 설정 정보에 붙은 어노테이션
//componentScan -> 스프릉 빈을 쫙 긁어서 자동으로 스프링 빈으로 등록
//보통 프로젝트 시작 루트에 메인 설정 클래스 파일 둔다.

@Configuration
@ComponentScan(
        basePackages = "helloCoreB.CoreBasic.member", //먼저 탐색할 패키지 지정
        basePackageClasses = AutoAppConfig.class, //먼저 탐색할 클래스
        //지정하지 않으면 ComponentScan이 붙은 설정정보 클래스의 패키지가  시작 위치가 된다.
        excludeFilters
                = @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = Configuration.class
        )
        //자동으로 스프링 빈으로 자동 등록하는데 그중에서 뺄 것을 등록
)
public class AutoAppConfig {
//        @Bean(name = "memoryMemberRepository") //자동과 수동의 빈이름이 충돌될 경우 수동으로 설정된 이름이 우선권을 가진다.
//        MemberRepository memberRepository() {
//                return new MemoryMemberRepository();
//        }
}
