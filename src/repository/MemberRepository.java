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
        try { // 회원가입 구현
            String sql = "" +
                    "INSERT INTO member (id, member_name, password, tel) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mem.getId());
            pstmt.setString(2, mem.getMember_name());
            pstmt.setString(3, mem.getPassword());
            pstmt.setString(4, mem.getTel());
            pstmt.executeUpdate();
            pstmt.close();

            System.out.println("회원 정보를 추가했습니다.");
        } catch (SQLException e) {
            System.out.println("이미 존재하는 아이디입니다. 다시 시도해주세요.");
        }
    }
    public void read(String id) {
        System.out.printf("\n%-8s%-10s%-18s%-18s\n", "NAME", "ID", "PWD", "TEL");
        System.out.println("-------------------------------------------------------");
        if (id == null) {
            try {
                String sql = "SELECT * FROM MEMBER";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()) {
                    Member mem = new Member();
                    mem.setMember_name(rs.getString("member_name"));
                    mem.setId(rs.getString("id"));
                    mem.setPassword(rs.getString("password"));
                    mem.setTel(rs.getString("tel"));
                    System.out.printf("%-6s%-10s%-18s%-18s\n",
                            mem.getMember_name(),
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
        else {
            try {
                String sql = "SELECT * FROM MEMBER WHERE ID = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()) {
                    Member mem = new Member();
                    mem.setMember_name(rs.getString("member_name"));
                    mem.setId(rs.getString("id"));
                    mem.setPassword(rs.getString("password"));
                    mem.setTel(rs.getString("tel"));
                    System.out.printf("%-6s%-10s%-18s%-18s\n",
                            mem.getMember_name(),
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
    public void update(Member member, String id) {
        try {
            String sql = "" +
                    "UPDATE MEMBER SET MEMBER_NAME = NVL2(?, ?, MEMBER_NAME)," +
                    "ID = NVL2(?, ?, ID)," +
                    "PASSWORD = NVL2(?, ?, PASSWORD)," +
                    "TEL = NVL2(?, ?, TEL)" +
                    "WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getMember_name());
            pstmt.setString(2, member.getMember_name());
            pstmt.setString(3, member.getId());
            pstmt.setString(4, member.getId());
            pstmt.setString(5, member.getPassword());
            pstmt.setString(6, member.getPassword());
            pstmt.setString(7, member.getTel());
            pstmt.setString(8, member.getTel());
            pstmt.setString(9, id);
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("회원 정보를 수정했습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(String id) {
        try {
            String sql = "DELETE FROM MEMBER WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeQuery();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
