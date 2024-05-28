package kiosk.util;

import kiosk.model.Order;

import java.util.List;

public class OrderReadyChecker extends Thread {
    private List<Order> orderList;

    public OrderReadyChecker(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public synchronized void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                for(Order order : orderList) {
                    if(order.getIsGetReady() && !order.getIsNoti()) {
                        System.out.println();
                        System.out.println("-----------------------");
                        System.out.println("메뉴 준비가 다 되었습니다.");
                        System.out.println("주문 번호 : " + order.getOrderNumber());
                        System.out.println("메뉴를 픽업하러 와주세요.");
                        System.out.println("-----------------------");
                        System.out.println();
                        order.setNoti();
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
