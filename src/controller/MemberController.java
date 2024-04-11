package controller;

import domain.Member;
import repository.MemberRepository;
import util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberController {
    private MemberRepository mr = new MemberRepository();
    Member mem = new Member();

    public void create(String name, String id, String pwd, String tel) {
        mem.setMember_name(name);
        mem.setId(id);
        mem.setPassword(pwd);
        if (tel.isEmpty()) mem.setTel(null);
        else mem.setTel(tel);

        mr.create(mem);
    }
    public void update(String id, String[] col) {
        mem.setMember_name(col[0]);
        mem.setId(col[1]);
        mem.setPassword(col[2]);
        mem.setTel(col[3]);

        mr.update(mem, id);
    }
    public void delete(String id) {
        mr.delete(id);
    }
    public void read(String id) {
        mr.read(id);
    }

    public String loginController(String id, String pwd) {
        return mr.login(id, pwd);
    }
}
