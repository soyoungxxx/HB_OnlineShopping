package controller;

import domain.Order_list;
import repository.OrderRepository;
import repository.Service;

public class OrderController {
    private Service service = new OrderRepository();

    public void create(Order_list ol) {

    }

    public void update(Order_list ol) {

    }

    public void delete(Order_list ol) {

    }

    public void read(Order_list ol) {
        service.read(ol);
    }
}
