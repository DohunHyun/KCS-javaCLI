package kiosk.util;

import kiosk.model.Order;

import java.util.concurrent.BlockingQueue;

public class OrderProcessor extends Thread {
    private BlockingQueue<Order> orderQueue;

    public OrderProcessor(BlockingQueue<Order> orderQueue) {
        this.orderQueue = orderQueue;
    }

    @Override
    public synchronized void run() {
        while(true) {
            try {
                Order order = orderQueue.take();
                Thread.sleep(order.getMenuList().size() * 10 * 1000);
                order.setReadyOrder();
                orderQueue.put(order);
            } catch (InterruptedException e) {
                System.out.println("Order processing thread interrupted.");
                Thread.currentThread().interrupt();
            }
        }
    }
}
