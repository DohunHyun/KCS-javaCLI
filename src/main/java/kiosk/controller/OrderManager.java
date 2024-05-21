package kiosk.controller;

import kiosk.model.*;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    static List<Order> orderList = new ArrayList<>();
    Order order;

    public OrderManager() {
        order = new Order(orderList.size());
    }

    public void makeOrder(Coffee coffee) {
        coffee.setMenuName(findNameByNumber(coffee));
        coffee.setPrice(findPriceByNumber(coffee));
        order.addMenuList(coffee);
    }

    public void makeOrder(Tea tea) {
        tea.setMenuName(findNameByNumber(tea));
        tea.setPrice(findPriceByNumber(tea));
        order.addMenuList(tea);
    }

    public void makeOrder(Juice juice) {
        juice.setMenuName(findNameByNumber(juice));
        juice.setPrice(findPriceByNumber(juice));
        order.addMenuList(juice);
    }

    public void makeOrder(Cake cake) {
        cake.setMenuName(findNameByNumber(cake));
        cake.setPrice(findPriceByNumber(cake));
        order.addMenuList(cake);
    }

    public void makeOrder(Bread bread) {
        bread.setMenuName(findNameByNumber(bread));
        bread.setPrice(findPriceByNumber(bread));
        order.addMenuList(bread);
    }

    String findNameByNumber(Coffee coffee) {
        MenuListMaker menuListMaker = new MenuListMaker();
        for(Menu item : menuListMaker.getCoffeeList()) {
            if(coffee.getMenuNumber() == item.getMenuNumber()) {
                return item.getMenuName();
            }
        }
        return "";
    }

    String findNameByNumber(Tea tea) {
        MenuListMaker menuListMaker = new MenuListMaker();
        for(Menu item : menuListMaker.getTeaList()) {
            if(tea.getMenuNumber() == item.getMenuNumber()) {
                return item.getMenuName();
            }
        }
        return "";
    }

    String findNameByNumber(Juice juice) {
        MenuListMaker menuListMaker = new MenuListMaker();
        for(Menu item : menuListMaker.getTeaList()) {
            if(juice.getMenuNumber() == item.getMenuNumber()) {
                return item.getMenuName();
            }
        }
        return "";
    }

    String findNameByNumber(Cake cake) {
        MenuListMaker menuListMaker = new MenuListMaker();
        for(Menu item : menuListMaker.getCakeList()) {
            if(cake.getMenuNumber() == item.getMenuNumber()) {
                return item.getMenuName();
            }
        }
        return "";
    }

    String findNameByNumber(Bread bread) {
        MenuListMaker menuListMaker = new MenuListMaker();
        for(Menu item : menuListMaker.getBreadList()) {
            if(bread.getMenuNumber() == item.getMenuNumber()) {
                return item.getMenuName();
            }
        }
        return "";
    }

    int findPriceByNumber(Coffee coffee) {
        MenuListMaker menuListMaker = new MenuListMaker();
        for(Menu item : menuListMaker.getCoffeeList()) {
            if(coffee.getMenuNumber() == item.getMenuNumber()) {
                return item.getPrice();
            }
        }
        return 0;
    }

    int findPriceByNumber(Tea tea) {
        MenuListMaker menuListMaker = new MenuListMaker();
        for(Menu item : menuListMaker.getTeaList()) {
            if(tea.getMenuNumber() == item.getMenuNumber()) {
                return item.getPrice();
            }
        }
        return 0;
    }

    int findPriceByNumber(Juice juice) {
        MenuListMaker menuListMaker = new MenuListMaker();
        for(Menu item : menuListMaker.getTeaList()) {
            if(juice.getMenuNumber() == item.getMenuNumber()) {
                return item.getPrice();
            }
        }
        return 0;
    }

    int findPriceByNumber(Cake cake) {
        MenuListMaker menuListMaker = new MenuListMaker();
        for(Menu item : menuListMaker.getCakeList()) {
            if(cake.getMenuNumber() == item.getMenuNumber()) {
                return item.getPrice();
            }
        }
        return 0;
    }

    int findPriceByNumber(Bread bread) {
        MenuListMaker menuListMaker = new MenuListMaker();
        for(Menu item : menuListMaker.getBreadList()) {
            if(bread.getMenuNumber() == item.getMenuNumber()) {
                return item.getPrice();
            }
        }
        return 0;
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
