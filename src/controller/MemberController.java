package controller;

import domain.Member;
import repository.MemberRepository;

public class MemberController {
    private MemberRepository mr = new MemberRepository();
    Member mem = new Member();
    public void create(String name, String id, String pwd, String tel) {
        mem.setName(name);
        mem.setId(id);
        mem.setPassword(pwd);
        if (tel.isEmpty()) mem.setTel(null);
        else mem.setTel(tel);

        mr.create(mem);
    }
    public void update(int member_no, String col, String change) {

    }
    public void delete(Member mem) {

    }
    public void read(Member mem) {
        if (mem == null) {
            mr.read(null);
        }
    }

    public String loginController(String id, String pwd) {
        return mr.login(id, pwd);
    }
}
