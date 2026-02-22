package najah;




public class ClientProgressReport {
    private Client client;
    private String report;

    public ClientProgressReport(Client client) {
        this.client = client;
    }

    public void generateReport() {
        this.report = "Milestones Achieved: 5, Attendance: 80%";
    }

    public String getReport() {
        return report;
    }
}