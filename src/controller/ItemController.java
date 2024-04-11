package controller;

import domain.Item;
import repository.ItemRepository;
import repository.Service;

public class ItemController {
    private Service service = new ItemRepository();
    Item item = new Item();
    public void create(String item_name, int price) {
        item.setItem_name(item_name);
        item.setPrice(price);
        service.create(item);
    }

    public void update(String item_name, String[] elements) {
        item.setItem_name(elements[0]);
        if (elements[1] != null) item.setPrice(Integer.parseInt(elements[1]));
        else item.setPrice(-1);
        service.update(item, item_name);
    }

    public void delete(String name) {
        service.delete(name);
    }

    public void read(String item) {
        service.read(item);
    }

}
