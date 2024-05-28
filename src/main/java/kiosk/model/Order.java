package kiosk.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    int orderNumber;
    boolean isReadyOrder = false;
    List<Menu> menuList;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber + 1;
        this.menuList = new ArrayList<>();
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void addMenuList(Menu menu) {
        menuList.add(menu);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public boolean getIsGetReady() {
        return isReadyOrder;
    }

    public void setReadyOrder() {
        this.isReadyOrder = true;
    }
}
