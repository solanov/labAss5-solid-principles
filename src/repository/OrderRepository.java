package repository;

import model.Order;

public interface OrderRepository {
    void placeOrder(Order order);
}