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
            // 새 배송정보 추가
            String sql = "" +
                    "INSERT INTO delivery_list (deli_no, order_no, id, address, del_date) " +
                    "VALUES (SEQ_DEL.NEXTVAL, ?, (SELECT O.ID FROM ORDER_LIST O WHERE O.ORDER_NO = ?), ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, del.getOrder_no());
            pstmt.setInt(2, del.getOrder_no());
            pstmt.setString(3, del.getAddress());
            pstmt.setDate(4, del.getDel_date());
            pstmt.executeUpdate();
            pstmt.close();

            System.out.println("배송 정보를 추가했습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void read(String id) {
        System.out.printf("%-7s%-6s%-8s%-25s%-15s\n", "배송번호", "주문번호", "회원번호", "주소", "배송날짜");
        System.out.println("------------------------------------------------------------------");
        if (id == null) {
            // 전체 데이터 조회
            try {
                String sql = "SELECT * FROM DELIVERY_LIST";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()) {
                    Delivery_list deliveryList = new Delivery_list();
                    deliveryList.setDeli_no(rs.getInt("deli_no"));
                    deliveryList.setOrder_no(rs.getInt("order_no"));
                    deliveryList.setId(rs.getString("id"));
                    deliveryList.setAddress(rs.getString("address"));
                    deliveryList.setDel_date(rs.getDate("del_date"));
                    System.out.printf("%-9s%-9s%-10s%-20s%-15s\n",
                            deliveryList.getDeli_no(),
                            deliveryList.getOrder_no(),
                            deliveryList.getId(),
                            deliveryList.getAddress(),
                            deliveryList.getDel_date());
                }
                rs.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                // 본인 데이터만 조회
                String sql = "SELECT * FROM DELIVERY_LIST WHERE ID = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()) {
                    Delivery_list deliveryList = new Delivery_list();
                    deliveryList.setDeli_no(rs.getInt("deli_no"));
                    deliveryList.setOrder_no(rs.getInt("order_no"));
                    deliveryList.setId(rs.getString("id"));
                    deliveryList.setAddress(rs.getString("address"));
                    deliveryList.setDel_date(rs.getDate("del_date"));
                    System.out.printf("%-9s%-9s%-10s%-20s%-15s\n",
                            deliveryList.getDeli_no(),
                            deliveryList.getOrder_no(),
                            deliveryList.getId(),
                            deliveryList.getAddress(),
                            deliveryList.getDel_date());
                }
                rs.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void update(Delivery_list deliveryList, String id) {
        try {
            String sql = "" +
                    "UPDATE DELIVERY_LIST SET ADDRESS = ? " +
                    "WHERE ID = ? AND ORDER_NO = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, deliveryList.getAddress());
            pstmt.setString(2, id);
            pstmt.setInt(3, deliveryList.getOrder_no());
            pstmt.executeUpdate();
            pstmt.close();

            System.out.println("배송지를 수정했습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(String id) {

    }
}
