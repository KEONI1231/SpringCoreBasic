package helloCoreB.CoreBasic;

import helloCoreB.CoreBasic.member.Grade;
import helloCoreB.CoreBasic.member.Member;
import helloCoreB.CoreBasic.member.MemberService;
import helloCoreB.CoreBasic.member.MemberServiceImpl;

public class MemberApp
{
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new findMember = "+ member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
