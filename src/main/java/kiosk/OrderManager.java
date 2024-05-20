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

    Order getOrder() {
        return order;
    }

    void charge() {
        // 결제 처리.
        orderList.add(order);
    }

    Order checkOrderByNumber(int orderNumber) {
        for(Order order : orderList) {
            if(order.orderNumber == orderNumber) {
                return order;
            }
        }
        return null;
    }
}
