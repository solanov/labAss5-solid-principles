import invoice.InvoiceGenerator;
import invoice.PdfInvoiceGenerator;
import model.Order;
import notification.EmailNotificationService;
import notification.NotificationService;
import repository.DatabaseOrderRepository;
import repository.OrderRepository;
import service.OrderCalculator;
import service.OrderProcessor;
import service.StandardOrderCalculator;

public class OrderTest {
    public static void main(String[] args) {
        // Setup dependencies
        OrderCalculator calculator = new StandardOrderCalculator();
        OrderRepository repository = new DatabaseOrderRepository();
        InvoiceGenerator invoiceGenerator = new PdfInvoiceGenerator();
        NotificationService emailNotifier = new EmailNotificationService();

        OrderProcessor processor = new OrderProcessor(calculator, repository, invoiceGenerator, emailNotifier);

        Order order = new Order("John Doe", "123 Main St", 10.0, 2);

        processor.process(order, "johndoe@example.com", "order_123.pdf");
    }
}