package najah;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    private List<Notification> notificationLog = new ArrayList<>();

    public void sendNotification(String message, List<Client> recipients) {
        for (Client client : recipients) {
            Notification notification = new Notification(message, client.getEmail());
            notificationLog.add(notification);
            SystemNotificationService.dispatch(notification);
        }
    }

    public void sendNotification(String message, Client recipient) {
        Notification notification = new Notification(message, recipient.getEmail());
        notificationLog.add(notification);
        SystemNotificationService.dispatch(notification);
    }

    public List<Notification> getNotificationLog() {
        return notificationLog;
    }
}