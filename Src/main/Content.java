package najah;
public class Content {
    private String title;
    private String status;

    public Content(String title) {
        this.title = title;
        this.status = "Pending";
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}