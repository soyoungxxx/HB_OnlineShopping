package repository;

import domain.Member;
import util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRepository implements Service<Member, String> {
    private Connection conn = DBConn.getConnection();

    public void create(Member mem) {
        try {
            String sql = "" +
                    "INSERT INTO member (member_no, name, id, password, tel) " +
                    "VALUES (SEQ_MEM.NEXTVAL, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mem.getName());
            pstmt.setString(2, mem.getId());
            pstmt.setString(3, mem.getPassword());
            pstmt.setString(4, mem.getTel());
            pstmt.executeUpdate();
            pstmt.close();

            System.out.println("회원 정보를 추가했습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void read(String id) {
        if (id == null) {
            try {
                String sql = "SELECT * FROM MEMBER";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()) {
                    Member mem = new Member();
                    mem.setMember_no(rs.getInt("member_no"));
                    mem.setName(rs.getString("name"));
                    mem.setId(rs.getString("id"));
                    mem.setPassword(rs.getString("password"));
                    mem.setTel(rs.getString("tel"));
                    System.out.printf("%3d%6s%10s%18s%18s\n",
                            mem.getMember_no(),
                            mem.getName(),
                            mem.getId(),
                            mem.getPassword(),
                            mem.getTel());
                }
                rs.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void update() {

    }
    public void delete() {

    }

    public String login(String id, String pwd) {
        String answer = null;
        try {
            String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                answer = rs.getString("id");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }

}
