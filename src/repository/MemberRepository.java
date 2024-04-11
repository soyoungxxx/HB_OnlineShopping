package repository;

import domain.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberRepository implements Service<Member> {
    private Connection conn = null;

    private void DbConnect() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "testuser", "test1234");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

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

            System.out.println("회원 정보를 추가했습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void read() {
        try {
            String sql = "" +
                    "SELECT member_no, name, id, password, tel " +
                    "FROM member " +
                    "WHERE bno=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bno);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(sc.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update() {

    }
    public void delete() {

    }

}
