package kiosk.controller;

import kiosk.model.Coffee;
import kiosk.model.Order;
import kiosk.model.Tea;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    static List<Order> orderList = new ArrayList<>();
    Order order;

    public OrderManager() {
        order = new Order(orderList.size());
    }

    public void makeOrder(Coffee coffee) {
        order.addMenuList(coffee);
    }

    public void makeOrder(Tea tea) {
        order.addMenuList(tea);
    }

    public Order getOrder() {
        return order;
    }

    public void charge() {
        // 결제 처리.
        orderList.add(order);
    }

    public Order checkOrderByNumber(int orderNumber) {
        for(Order order : orderList) {
            if(order.getOrderNumber() == orderNumber) {
                return order;
            }
        }
        return null;
    }
}
