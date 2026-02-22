package najah;

import java.time.LocalDateTime;

public class Notification {
    private String message;
    private String recipient;
    private LocalDateTime timestamp;

    public Notification(String message, String recipient) {
        this.message = message;
        this.recipient = recipient;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public String getRecipient() {
        return recipient;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Notification to " + recipient + ": " + message + " at " + timestamp;
    }
}