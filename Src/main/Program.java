package najah;

import java.util.Collection;
import java.util.List;

public class Program {
    private String title;
    private int duration; // in weeks or months
    private String difficulty;
    private String goals;
    private List<String> media; // URLs or file paths
    private double price;
    private String schedule;

    // Constructor with List<String> for media

    public Program(String title, int duration, String difficulty, String goals, List<String> media, double price) {

        this.title = title;
        this.duration = duration;
        this.difficulty = difficulty;
        this.goals = goals;
        this.media = (media);  // Convert single media String to a list
        this.price = price;
    }

    // Constructor with single String for media
    public Program(String title, int duration, String difficulty, String goals, String media, double price) {
        this.title = title;
        this.duration = duration;
        this.difficulty = difficulty;
        this.goals = goals;
        this.media = List.of(media);  // Convert single media String to a list
        this.price = price;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public List<String> getMedia() {
        return media;
    }

    public void setMedia(List<String> media) {
        this.media = media;
    }

    // Set media using a single String, converted to List
    public void setMedia(String media) {
        this.media = List.of(media);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Schedule setter and getter
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSchedule() {
        return schedule;
    }

     public Collection<Client> getClients() {
        return List.of();
    }
}