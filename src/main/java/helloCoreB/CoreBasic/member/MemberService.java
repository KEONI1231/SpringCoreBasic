package helloCoreB.CoreBasic.member;


//회원 관련 비즈니스 로직을 수행할 서비스의 인터페이스를 정의
/*
    ex) 회원 가입할때 해당 정보가 가입가능한지 등을 판단하는 기능


 */
public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
