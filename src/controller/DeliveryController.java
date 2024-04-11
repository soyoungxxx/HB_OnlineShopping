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
        deliveryList.setDeli_date(Date.valueOf(date));

        service.create(deliveryList);
    }

    public void update(Delivery_list dl) {

    }

    public void delete(Delivery_list dl) {

    }

    public void read(Delivery_list dl) {
        service.read(dl);
    }
}
