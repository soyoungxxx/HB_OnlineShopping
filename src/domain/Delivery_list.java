package domain;

import lombok.Data;

import java.util.Date;

@Data
public class Delivery_list {
    private int deli_no;
    private String address;
    private Date deli_date;
    private int order_no;
    private int member_no;
}
