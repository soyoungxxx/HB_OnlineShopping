package domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Delivery_list {
    private int deli_no;
    private String address;
    private Date del_date;
    private int order_no;
    private String id;
}
