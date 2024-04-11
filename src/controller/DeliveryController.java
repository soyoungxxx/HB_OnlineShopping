package controller;

import domain.Delivery_list;
import repository.DeliveryRepository;
import repository.Service;

import java.sql.Date;

public class DeliveryController {
    private Service service = new DeliveryRepository();
    Delivery_list deliveryList = new Delivery_list();

    public void create(int order_no, String address, String date) {
        deliveryList.setOrder_no(order_no);
        deliveryList.setAddress(address);
        deliveryList.setDel_date(Date.valueOf(date));

        service.create(deliveryList);
    }

    public void update(String address, String id, int order_no) {
        deliveryList.setAddress(address);
        deliveryList.setId(id);
        deliveryList.setOrder_no(order_no);
        service.update(deliveryList, id);
    }

    public void delete(Delivery_list dl) {

    }

    public void read(String id) {
        service.read(id);
    }
}
