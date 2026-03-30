package notification;

public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Email notification sent to " + recipient + ": " + message);
    }
}
