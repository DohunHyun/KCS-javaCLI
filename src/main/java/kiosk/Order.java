package kiosk;

import java.util.List;

public class Order {
    int orderNumber;
    int lastOrderNumber;
    List<Menu> menuList;

    Order(int orderNumber) {
        this.orderNumber = orderNumber + 1;
    }
}
