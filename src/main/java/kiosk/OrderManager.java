package kiosk;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    static List<Order> orderList = new ArrayList<>();
    Order order;

    OrderManager() {
        order = new Order(orderList.size());
    }

    void makeOrder(Coffee coffee) {
        order.menuList.add(coffee);
    }
}
