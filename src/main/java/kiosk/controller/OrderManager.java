package kiosk.controller;

import kiosk.model.*;
import kiosk.util.OrderProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class OrderManager {
    static List<Order> orderList = new ArrayList<>();
    Order order;
    BlockingQueue<Order> orderQueue = new ArrayBlockingQueue<>(10);
    OrderProcessor orderProcessor = new OrderProcessor(orderQueue);

    public OrderManager() {
        order = new Order(orderList.size());
        orderProcessor.start();
    }

    // 주문 만들기
    public void makeOrder(Coffee coffee) {
        coffee.setMenuName(findNameByNumber(coffee));
        coffee.setPrice(findPriceByNumber(coffee));
        order.addMenuList(coffee);
        addOrderToQueue(order);
    }

    public void makeOrder(Tea tea) {
        tea.setMenuName(findNameByNumber(tea));
        tea.setPrice(findPriceByNumber(tea));
        order.addMenuList(tea);
        addOrderToQueue(order);
    }

    public void makeOrder(Juice juice) {
        juice.setMenuName(findNameByNumber(juice));
        juice.setPrice(findPriceByNumber(juice));
        order.addMenuList(juice);
        addOrderToQueue(order);
    }

    public void makeOrder(Ade ade) {
        ade.setMenuName(findNameByNumber(ade));
        ade.setPrice(findPriceByNumber(ade));
        order.addMenuList(ade);
        addOrderToQueue(order);
    }

    public void makeOrder(Cake cake) {
        cake.setMenuName(findNameByNumber(cake));
        cake.setPrice(findPriceByNumber(cake));
        order.addMenuList(cake);
        addOrderToQueue(order);
    }

    public void makeOrder(Bread bread) {
        bread.setMenuName(findNameByNumber(bread));
        bread.setPrice(findPriceByNumber(bread));
        order.addMenuList(bread);
        addOrderToQueue(order);
    }

    public void addOrderToQueue(Order order) {
        try {
            orderQueue.put(order);
        } catch (InterruptedException e) {
            System.out.println("주문을 큐에 추가하는데 실패했습니다.");
            Thread.currentThread().interrupt();
        }
    }

    // 주문 시 메뉴 이름 찾아서 저장
    String findNameByNumber(Coffee coffee) {
        MenuListMaker menuListMaker = MenuListMaker.getMenuListMaker();
        for(Menu item : menuListMaker.getCoffeeList()) {
            if(coffee.getMenuNumber() == item.getMenuNumber()) {
                return item.getMenuName();
            }
        }
        return "";
    }

    String findNameByNumber(Tea tea) {
        MenuListMaker menuListMaker = MenuListMaker.getMenuListMaker();
        for(Menu item : menuListMaker.getTeaList()) {
            if(tea.getMenuNumber() == item.getMenuNumber()) {
                return item.getMenuName();
            }
        }
        return "";
    }

    String findNameByNumber(Juice juice) {
        MenuListMaker menuListMaker = MenuListMaker.getMenuListMaker();
        for(Menu item : menuListMaker.getJuiceList()) {
            if(juice.getMenuNumber() == item.getMenuNumber()) {
                return item.getMenuName();
            }
        }
        return "";
    }

    String findNameByNumber(Ade ade) {
        MenuListMaker menuListMaker = MenuListMaker.getMenuListMaker();
        for(Menu item : menuListMaker.getAdeList()) {
            if(ade.getMenuNumber() == item.getMenuNumber()) {
                return item.getMenuName();
            }
        }
        return "";
    }

    String findNameByNumber(Cake cake) {
        MenuListMaker menuListMaker = MenuListMaker.getMenuListMaker();
        for(Menu item : menuListMaker.getCakeList()) {
            if(cake.getMenuNumber() == item.getMenuNumber()) {
                return item.getMenuName();
            }
        }
        return "";
    }

    String findNameByNumber(Bread bread) {
        MenuListMaker menuListMaker = MenuListMaker.getMenuListMaker();
        for(Menu item : menuListMaker.getBreadList()) {
            if(bread.getMenuNumber() == item.getMenuNumber()) {
                return item.getMenuName();
            }
        }
        return "";
    }

    // 주문 시 메뉴 가격 찾아서 저장
    int findPriceByNumber(Coffee coffee) {
        MenuListMaker menuListMaker = MenuListMaker.getMenuListMaker();
        for(Menu item : menuListMaker.getCoffeeList()) {
            if(coffee.getMenuNumber() == item.getMenuNumber()) {
                return item.getPrice();
            }
        }
        return 0;
    }

    int findPriceByNumber(Tea tea) {
        MenuListMaker menuListMaker = MenuListMaker.getMenuListMaker();
        for(Menu item : menuListMaker.getTeaList()) {
            if(tea.getMenuNumber() == item.getMenuNumber()) {
                return item.getPrice();
            }
        }
        return 0;
    }

    int findPriceByNumber(Juice juice) {
        MenuListMaker menuListMaker = MenuListMaker.getMenuListMaker();
        for(Menu item : menuListMaker.getJuiceList()) {
            if(juice.getMenuNumber() == item.getMenuNumber()) {
                return item.getPrice();
            }
        }
        return 0;
    }

    int findPriceByNumber(Ade ade) {
        MenuListMaker menuListMaker = MenuListMaker.getMenuListMaker();
        for(Menu item : menuListMaker.getAdeList()) {
            if(ade.getMenuNumber() == item.getMenuNumber()) {
                return item.getPrice();
            }
        }
        return 0;
    }

    int findPriceByNumber(Cake cake) {
        MenuListMaker menuListMaker = MenuListMaker.getMenuListMaker();
        for(Menu item : menuListMaker.getCakeList()) {
            if(cake.getMenuNumber() == item.getMenuNumber()) {
                return item.getPrice();
            }
        }
        return 0;
    }

    int findPriceByNumber(Bread bread) {
        MenuListMaker menuListMaker = MenuListMaker.getMenuListMaker();
        for(Menu item : menuListMaker.getBreadList()) {
            if(bread.getMenuNumber() == item.getMenuNumber()) {
                return item.getPrice();
            }
        }
        return 0;
    }

    // 결제하기
    public void charge() {
        // 결제 처리.
        orderList.add(order);
        this.order = new Order(orderList.size());
    }

    // 주문 번호로 주문 확인
    public Order checkOrderByNumber(int orderNumber) {
        for(Order order : orderList) {
            if(order.getOrderNumber() == orderNumber) {
                return order;
            }
        }
        return null;
    }

    public Order getOrder() {
        return this.order;
    }
}
