package controller;

import domain.Order_list;
import repository.OrderRepository;
import repository.Service;

public class OrderController {
    private Service service = new OrderRepository();

    public void create(int item_no, int quantity, String id) {
        Order_list orderList = new Order_list();
        orderList.setQuantity(quantity);
        orderList.setItem_no(item_no);
        orderList.setId(id);
        service.create(orderList);
    }

    public void update(Order_list ol) {

    }

    public void delete(Order_list ol) {

    }

    public void read(String id) {
        service.read(id);
    }
}
