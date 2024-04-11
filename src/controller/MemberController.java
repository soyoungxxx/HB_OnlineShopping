package controller;

import domain.Member;
import repository.MemberRepository;

public class MemberController implements Controller<Member> {
    private MemberRepository mr = new MemberRepository();
    public void create(Member mem) {
        mr.create(mem);
    }
    public void update(Member mem) {

    }
    public void delete(Member mem) {

    }
    public void read(Member mem) {

    }

    public String loginController(String id, String pwd) {
        return mr.login(id, pwd);
    }
}
