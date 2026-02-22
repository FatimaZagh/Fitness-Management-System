package najah;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Instructor {
    private Map<String, Client> clients;
    private String name;
    private String email;
    private List<Program> programs;

    // Constructor with name and email
    public Instructor(String name, String email) {
        this.name = name;
        this.email = email;
        this.programs = new ArrayList<>();
    }

    // Constructor (empty, to be used if needed for other cases)
    public Instructor(String string) {
        // Placeholder constructor
    }

    // Add a program
    public void addProgram(Program program) {
        programs.add(program);
    }

    // Update an existing program
    public void updateProgram(String title, Program updatedProgram) {
        for (int i = 0; i < programs.size(); i++) {
            if (programs.get(i).getTitle().equals(title)) {
                programs.set(i, updatedProgram);
                return;
            }
        }
    }

    // Delete a program by title
    public boolean deleteProgram(String title) {
        return programs.removeIf(program -> program.getTitle().equals(title));
    }

    // Get a list of all programs
    public List<Program> getPrograms() {
        return programs;
    }

    // Get a list of all clients enrolled across all programs
    public List<Client> getClients() {
        List<Client> collectedClients = new ArrayList<>();
        for (Program program : programs) {
            collectedClients.addAll(program.getClients());
        }
        return collectedClients;
    }

    // Set clients map (if needed for future use)

    // Send personalized recommendations to a client based on progress
    public String sendPersonalizedRecommendations(Client client) {
        String recommendations = "Focus on improving your attendance!";
        if (client.getCompletionRate() < 50) {
            recommendations = "Work on consistency and achieving milestones!";
        }
        client.setFeedback(recommendations);
        return recommendations;
    }



    // Send motivational reminder to a client
    public String sendMotivationalReminder(Client client) {
        String message = "Keep up the great work!";
        if (client.getCompletionRate() < 60) {
            message = "Stay consistent and you'll reach your goals!";
        }
        client.notify(message);
        return message;
    }

    public void setClients(Map<String, Client> clients) {
        this.clients = clients; // Assign the provided map to the class-level variable
    } }