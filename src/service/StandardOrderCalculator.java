package service;

import model.Order;

public class StandardOrderCalculator implements OrderCalculator {

    @Override
    public double calculateTotal(Order order) {
        double total = order.getPrice() * order.getQuantity();
        System.out.println("Order total: $" + total);
        return total;
    }
}