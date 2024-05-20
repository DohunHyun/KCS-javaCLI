package kiosk;

import java.util.ArrayList;
import java.util.List;

public class Order {
    int orderNumber;
    boolean isReadyOrder = false;
    List<Menu> menuList;

    Order(int orderNumber) {
        this.orderNumber = orderNumber + 1;
        this.menuList = new ArrayList<>();
    }
}
