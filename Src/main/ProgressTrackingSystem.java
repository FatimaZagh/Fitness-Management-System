package najah;

import java.util.ArrayList;
import java.util.List;

public class ProgressTrackingSystem {
    private Instructor loggedInInstructor;
    private List<Client> enrolledClients = new ArrayList<>();
    private String scheduleUpdate;

    public void loginInstructor(Instructor instructor) {
        this.loggedInInstructor = instructor;
    }

    public void enrollClient(Instructor instructor, Client client) {
        if (loggedInInstructor != null && loggedInInstructor.equals(instructor)) {
            enrolledClients.add(client);
        }
    }

    public boolean sendMessageToClients(Instructor instructor, String message) {
        if (message == null || message.isEmpty()) {
            return false;
        }

        if (loggedInInstructor != null && loggedInInstructor.equals(instructor)) {
            for (Client client : enrolledClients) {
                client.notify(message);
            }
            return true;
        }
        return false;
    }

    public void replyToQuery(Instructor instructor, Client client, String response) {
        if (loggedInInstructor != null && loggedInInstructor.equals(instructor)) {
            client.notify(response);
        }
    }

    public void updateProgress(Client client, int completionRate, int attendance) {
        client.setProgress(completionRate, attendance);
    }

    public void addFeedback(Client client, String feedback) {
        client.setFeedback(feedback);
    }

    public void updateSchedule(String schedule) {
        this.scheduleUpdate = schedule;
    }

    public void notifyClientsAboutUpdate() {
        for (Client client : enrolledClients) {
            client.notify(scheduleUpdate);
        }
    }

    public String validateMessage(String message) {
        if (message == null || message.isEmpty()) {
            return "Invalid message content.";
        }
        if (message.length() > 500) {
            return "Message is too long.";
        }
        return null;
    }

    public void createDiscussionTopic(Instructor instructor, String topic) {
        if (loggedInInstructor != null && loggedInInstructor.equals(instructor)) {
            for (Client client : enrolledClients) {
                client.addDiscussionTopic(topic);
            }
        }
    }
}