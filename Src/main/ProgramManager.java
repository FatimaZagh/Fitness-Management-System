package najah;

import java.util.List;

public class ProgramManager {
    private NotificationManager notificationManager;

    public ProgramManager(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }

    public void updateProgramSchedule(List<Client> enrolledClients) {
        String message = "The program schedule has been updated. Please check your dashboard for details.";
        notificationManager.sendNotification(message, enrolledClients);
    }

    public void announceNewProgram(String programName, List<Client> potentialClients) {
        String message = "A new program \"" + programName + "\" is now available! Check it out on your dashboard.";
        notificationManager.sendNotification(message, potentialClients);
    }

    public void promoteSpecialOffer(String offerDetails, List<Client> clients) {
        String message = "Special offer: " + offerDetails + " Don't miss out!";
        notificationManager.sendNotification(message, clients);
    }

    public void remindUpcomingSession(String sessionDetails, List<Client> enrolledClients) {
        String message = "Reminder: Upcoming session - " + sessionDetails;
        notificationManager.sendNotification(message, enrolledClients);
    }

    public void notifyProgramCompletion(String programName, List<Client> enrolledClients) {
        String message = "The program \"" + programName + "\" has been completed. You can access archived materials now.";
        notificationManager.sendNotification(message, enrolledClients);
    }

    public void reEngageInactiveClients(String personalizedMessage, List<Client> inactiveClients) {
        notificationManager.sendNotification(personalizedMessage, inactiveClients);
    }
}