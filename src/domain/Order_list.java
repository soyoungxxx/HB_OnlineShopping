package domain;

import lombok.Data;

import java.util.Date;

@Data
public class Order_list {
    private int order_no;
    private Date order_date;
    private int quantity;
    private int sales;
    private int item_no;
}
