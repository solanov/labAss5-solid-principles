package service;

import invoice.InvoiceGenerator;
import model.Order;
import notification.NotificationService;
import repository.OrderRepository;

public class OrderProcessor {
    private final OrderCalculator calculator;
    private final OrderRepository repository;
    private final InvoiceGenerator invoiceGenerator;
    private final NotificationService notificationService;

    // Dependencies are injected via constructor
    public OrderProcessor(OrderCalculator calculator,
                          OrderRepository repository,
                          InvoiceGenerator invoiceGenerator,
                          NotificationService notificationService) {
        this.calculator = calculator;
        this.repository = repository;
        this.invoiceGenerator = invoiceGenerator;
        this.notificationService = notificationService;
    }

    public void process(Order order, String email, String invoiceFileName) {
        calculator.calculateTotal(order);
        repository.placeOrder(order);

        // These are now loosely coupled and can be easily toggled or replaced
        if (invoiceFileName != null) {
            invoiceGenerator.generateInvoice(invoiceFileName);
        }
        if (email != null) {
            notificationService.sendNotification(email, "Your order has been placed successfully!");
        }
    }
}