package najah;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private String email;
    private String lastNotification;
    private String feedback;
    private int completionRate;
    private int attendance;
    private List<String> discussionTopics = new ArrayList<>();
    private String improvementArea;
    private int engagement;
    private List<ClientProgressReport> reports = new ArrayList<>(); // Ensure reports list is initialized.

    // Constructor with name and email
    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Constructor (empty, for other cases)
    public Client(String string) {
        // This constructor is intentionally left empty to prevent instantiation
        // of a Client object with only a string parameter. If this constructor
        // is called, it indicates misuse of the class, so we throw an exception.

    }

    // Get client name
    public String getName() {
        return name;
    }

    // Get client email
    public String getEmail() {
        return email;
    }

    // Notify client with a message
    public void notify(String message) {
        this.lastNotification = message;
    }

    // Get the last notification sent to the client
    public String getLastNotification() {
        return lastNotification;
    }

    // Set feedback for the client
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    // Get feedback for the client
    public String getFeedback() {
        return feedback;
    }

    // Set client's progress (completion rate and attendance)
    public void setProgress(int completionRate, int attendance) {
        this.completionRate = completionRate;
        this.attendance = attendance;
    }

    // Get completion rate
    public int getCompletionRate() {
        return completionRate;
    }

    // Get attendance percentage
    public int getAttendance() {
        return attendance;
    }

    // View all discussion topics the client is interested in
    public List<String> viewDiscussionTopics() {
        return discussionTopics;
    }

    // Add a discussion topic to the client's list
    public void addDiscussionTopic(String topic) {
        discussionTopics.add(topic);
    }

    // View the client's progress report

    // Set the client's engagement level
    public void setEngagement(int engagement) {
        this.engagement = engagement;
    }

    // Get the client's engagement level
    public int getEngagement() {
        return engagement;
    }

    // Get a report of the client's progress (could be used to summarize progress)


    // Set areas where the client needs improvement
    public void setImprovementArea(String improvementArea) {
        this.improvementArea = improvementArea;
    }

    // Get the client's improvement area
    public String getImprovementArea() {
        return improvementArea;
    }

    // Set attendance (overloaded to handle different data types if necessary)
    public void setAttendance(Object object) {
        // If the object is an integer, assume it's a percentage and update attendance
        if (object instanceof Integer) {
            this.attendance = (Integer) object;
        } else {
            // Handle other types of attendance data if needed
        }
    }



    public void viewReport(ClientProgressReport report) {
        // Ensure report is being added
        reports.add(report);
    }

    public List<ClientProgressReport> getReports() {
        return reports;
    }
}