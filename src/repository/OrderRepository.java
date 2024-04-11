package repository;

import domain.Member;
import domain.Order_list;
import util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepository implements Service<Order_list, String> {
    private Connection conn = DBConn.getConnection();

    public void create(Order_list order) {
        try {
            String sql = "" +
                    "INSERT INTO ORDER_LIST (ORDER_NO, ORDER_DATE, QUANTITY, SALES, ITEM_NO, ID) " +
                    "VALUES (SEQ_ORDER.NEXTVAL, SYSDATE, ?, (SELECT PRICE FROM ITEM WHERE ITEM_NO = ?) * ?" +
                    ", ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, order.getQuantity());
            pstmt.setInt(2, order.getItem_no());
            pstmt.setInt(3, order.getQuantity());
            pstmt.setInt(4, order.getItem_no());
            pstmt.setString(5, order.getId());
            pstmt.executeUpdate();
            pstmt.close();

            System.out.println("상품을 주문하였습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void read(String id) {
        System.out.printf("\n%-3s%-10s%-6s%-5s%-10s%-18s\n", "NO", "ID", "상품번호", "수량", "가격", "주문일자");
        System.out.println("---------------------------------------------------------------");
        if (id == null) {
            try {
                String sql = "SELECT order_no, id, item_no, quantity, sales, order_date FROM ORDER_LIST";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()) {
                    Order_list order_list = new Order_list();
                    order_list.setOrder_no(rs.getInt("order_no"));
                    order_list.setId(rs.getString("id"));
                    order_list.setItem_no(rs.getInt("item_no"));
                    order_list.setOrder_date(rs.getDate("order_date"));
                    order_list.setQuantity(rs.getInt("quantity"));
                    order_list.setSales(rs.getInt("sales"));
                    System.out.printf("%-3s%-10s%-10s%-5s%-10s%-18s\n",
                            order_list.getOrder_no(),
                            order_list.getId(),
                            order_list.getItem_no(),
                            order_list.getQuantity(),
                            order_list.getSales(),
                            order_list.getOrder_date());
                }
                rs.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                String sql = "SELECT order_no, id, item_no, quantity, sales, order_date" +
                        " FROM ORDER_LIST WHERE ID = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()) {
                    Order_list order_list = new Order_list();
                    order_list.setOrder_no(rs.getInt("order_no"));
                    order_list.setId(rs.getString("id"));
                    order_list.setItem_no(rs.getInt("item_no"));
                    order_list.setOrder_date(rs.getDate("order_date"));
                    order_list.setQuantity(rs.getInt("quantity"));
                    order_list.setSales(rs.getInt("sales"));
                    System.out.printf("%-3s%-10s%-10s%-5s%-10s%-18s\n",
                            order_list.getOrder_no(),
                            order_list.getId(),
                            order_list.getItem_no(),
                            order_list.getQuantity(),
                            order_list.getSales(),
                            order_list.getOrder_date());
                }
                rs.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void update(Order_list orderList, String str) {

    }
    public void delete(String id) {

    }
}
