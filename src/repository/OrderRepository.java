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

    }
    public void read(String id) {
        if (id == null) {
            try {
                String sql = "SELECT * FROM ORDER_LIST";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()) {
                    Order_list order_list = new Order_list();
                    order_list.setOrder_no(rs.getInt("order_no"));
                    order_list.setMember_no(rs.getInt("member_no"));
                    order_list.setItem_no(rs.getInt("item_no"));
                    order_list.setOrder_date(rs.getDate("order_date"));
                    order_list.setQuantity(rs.getInt("quantity"));
                    order_list.setSales(rs.getInt("sales"));
                    System.out.printf("%3d%3s%3s%18s%3s%18s\n",
                            order_list.getOrder_no(),
                            order_list.getMember_no(),
                            order_list.getItem_no(),
                            order_list.getOrder_date(),
                            order_list.getQuantity(),
                            order_list.getSales());
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
