package helloCoreB.CoreBasic.member;

//회원 데이터에 접근하기 위한 저장소의 인터페이스를 정의
//save와 findById 메서드를 통해 어떤 저장소에서든 회원을 저장하고 검색가능.

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
