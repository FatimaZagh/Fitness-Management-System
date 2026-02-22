package najah;

public class Feedback {

    private int id;
    private String message;
    private String submittedBy;
    private String response;

    public Feedback(int id, String message, String submittedBy, String response) {
        this.id = id;
        this.message = message;
        this.submittedBy = submittedBy;
        this.response = response;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}