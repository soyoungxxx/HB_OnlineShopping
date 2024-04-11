package repository;

import domain.Item;
import util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRepository implements Service<Item, String> {
    private Connection conn = DBConn.getConnection();
    public void create(Item item) {
        try {
            String sql = "" +
                    "INSERT INTO item (item_no, item_name, price) " +
                    "VALUES (SEQ_ITEM.NEXTVAL, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, item.getItem_name());
            pstmt.setInt(2, item.getPrice());
            pstmt.executeUpdate();
            pstmt.close();

            System.out.println("상품 정보를 추가했습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void read(String item_name) {
        if (item_name == null) {
            try {
                String sql = "SELECT * FROM ITEM";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()) {
                    Item item = new Item();
                    item.setItem_no(rs.getInt("item_no"));
                    item.setItem_name(rs.getString("item_name"));
                    item.setPrice(rs.getInt("price"));
                    System.out.printf("%3d%15s%10d\n",
                            item.getItem_no(),
                            item.getItem_name(),
                            item.getPrice());
                }
                rs.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void update(Item item, String item_name) {
        try {
            String sql = "" +
                    "UPDATE ITEM SET ITEM_NAME = NVL2(?, ?, ITEM_NAME)," +
                    "PRICE = NVL2(?, ?, PRICE)" +
                    "WHERE ITEM_NAME = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, item.getItem_name());
            pstmt.setString(2, item.getItem_name());
            if (item.getPrice() == -1) {
                pstmt.setObject(3,null);
                pstmt.setString(4,"PRICE");
            }
            else {
                pstmt.setInt(4,item.getPrice());
            }
            pstmt.setString(5, item_name);
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("상품 정보를 수정했습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(String name) {
        try {
            String sql = "DELETE FROM ITEM WHERE ITEM_NAME = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.executeQuery();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
