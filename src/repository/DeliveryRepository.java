package repository;

import domain.Delivery_list;
import util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryRepository implements Service<Delivery_list, String> {
    private Connection conn = DBConn.getConnection();

    public void create(Delivery_list del) {
        try {
            String sql = "" +
                    "INSERT INTO delivery_list (deli_no, order_no, member_no, address, deli_date) " +
                    "VALUES (SEQ_DEL.NEXTVAL, ?, (SELECT MEMBER_NO FROM ORDER_LIST O WHERE O.ORDER_NO = ORDER_NO), ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, del.getOrder_no());
            pstmt.setString(2, del.getAddress());
            pstmt.setDate(3, del.getDeli_date());
            pstmt.executeUpdate();
            pstmt.close();

            System.out.println("배송 정보를 추가했습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void read(String id) {
        if (id == null) {
            try {
                String sql = "SELECT * FROM DELIVERY_LIST";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()) {
                    Delivery_list deliveryList = new Delivery_list();
                    deliveryList.setDeli_no(rs.getInt("deli_no"));
                    deliveryList.setOrder_no(rs.getInt("order_no"));
                    deliveryList.setMember_no(rs.getInt("member_no"));
                    deliveryList.setAddress(rs.getString("address"));
                    deliveryList.setDeli_date(rs.getDate("deli_date"));
                    System.out.printf("%-7s%-7s%-7s%-15s%-15s\n", "배송번호", "주문번호", "회원번호", "주소", "배송날짜");
                    System.out.printf("%-9s%-9s%-7s%-15s%-15s\n",
                            deliveryList.getDeli_no(),
                            deliveryList.getOrder_no(),
                            deliveryList.getMember_no(),
                            deliveryList.getAddress(),
                            deliveryList.getDeli_date());
                }
                rs.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void update(Delivery_list deliveryList, String str) {

    }
    public void delete(String id) {

    }
}
