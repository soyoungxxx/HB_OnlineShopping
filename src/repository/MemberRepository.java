package repository;

import domain.Member;
import util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberRepository implements Service<Member> {
    private Connection conn = DBConn.getConnection();

    public void create(Member mem) {
        try {
            String sql = "" +
                    "INSERT INTO member (member_no, name, id, password, tel) " +
                    "VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mem.getName());
            pstmt.setString(2, mem.getId());
            pstmt.setString(3, mem.getPassword());
            pstmt.setString(4, mem.getTel());
            pstmt.executeUpdate();
            pstmt.close();
            DBConn.close();

            System.out.println("회원 정보를 추가했습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void read() {

    }
    public void update() {

    }
    public void delete() {

    }

    public String login(String id, String pwd) {
        return id;
    }

}
