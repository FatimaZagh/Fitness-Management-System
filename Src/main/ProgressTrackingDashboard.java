package najah;

public class ProgressTrackingDashboard {
    private Instructor instructor;

    public ProgressTrackingDashboard(Instructor instructor) {
        this.instructor = instructor;
    }

    public void open() {
        // Simulate opening the dashboard
    }

    public String getClientProgress(Client client) {
        return "Completion Rate: 80%, Attendance: 90%";
    }

    public String checkForMissingData(Client client) {
        return "Missing data for attendance.";
    }

    public boolean flagMissingData(Client client) {
        return true; // Flag the issue for resolution
    }

    public String getProgramWideMetrics() {
        return "Average Completion Rate: 85%, Average Attendance: 75%";
    }
}
