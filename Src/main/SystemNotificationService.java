package najah;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemNotificationService {
    private static final Logger logger = LoggerFactory.getLogger(SystemNotificationService.class);

    // Private constructor to prevent instantiation
    private SystemNotificationService() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    public static void dispatch(Notification notification) {
        // Simulates sending a notification (e.g., email or system notification)
        logger.info(notification.toString()); // Use logger instead of System.out
    }
}