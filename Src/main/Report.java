package najah;

public class Report {
    private String title;
    private String content;

    // Constructor
    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Override toString() for easier debugging
    @Override
    public String toString() {
        return "Report{title='" + title + "', content='" + content + "'}";
    }
}