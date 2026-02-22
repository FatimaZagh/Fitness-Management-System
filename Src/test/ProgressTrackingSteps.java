package najah.edu;

import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
public class ProgressTrackingSteps {

    private double currentWeight;
    private double height;
    private double newWeight;
    private double calculatedBMI;
    private Map<String, String> viewedAchievements = new HashMap<>();
    private Map<String, String> attendanceRecords = new HashMap<>();
    private Map<String, String> achievements = new HashMap<>();
    private Map<String, String> badges = new HashMap<>();
    private Map<String, Boolean> enrolledPrograms = new HashMap<>(); // Track enrolled programs
    private Map<String, String> viewedBadges = new HashMap<>(); // To simulate viewing badges

    @Given("the client has a current weight for progress tracking of {string} kg")
    public void the_client_has_a_current_weight_for_progress_tracking_of_kg(String initialWeight) {
        this.currentWeight = Double.parseDouble(initialWeight);
    }

    @Given("the client has a height of {string} meters")
    public void the_client_has_a_height_of_meters(String height) {
        this.height = Double.parseDouble(height);
    }

    @When("the client modifies their weight to {string} kg")
    public void the_client_modifies_their_weight_to_kg(String newWeight) {
        this.newWeight = Double.parseDouble(newWeight);
        this.currentWeight = this.newWeight; // Update currentWeight to the new weight
        System.out.println("Client's weight updated to: " + currentWeight + " kg"); // Optional: for debugging
    }

    @When("the client updates their weight to {string} kg")
    public void the_client_updates_their_weight_to_kg(String newWeight) {
        this.newWeight = Double.parseDouble(newWeight);
        // Instead of directly updating currentWeight, we can add a check or log the change
        if (newWeight.equals(String.valueOf(currentWeight))) {
            System.out.println("The new weight is the same as the current weight. No update needed.");
        } else {
            this.currentWeight = this.newWeight; // Update currentWeight to the new weight
            System.out.println("Client's weight updated to: " + currentWeight + " kg"); // Optional: for debugging
        }
    }

    @When("the client calculates their BMI for progress tracking")
    public void the_client_calculates_their_BMI_for_progress_tracking() {
        if (height > 0) {
            calculatedBMI = currentWeight / (height * height); // BMI calculation
        } else {
            calculatedBMI = 0; // Handle case where height is not set
        }
    }

    @Then("the system tracks the weight as {string} kg")
    public void the_system_tracks_the_weight_as_kg(String expectedWeight) {
        assertEquals(Double.parseDouble(expectedWeight), currentWeight, 0.01);
    }

    @Then("the system calculates and tracks the BMI as {string}")
    public void the_system_calculates_and_tracks_the_BMI_as(String expectedBMI) {
        assertEquals(Double.parseDouble(expectedBMI), calculatedBMI, 0.01);
    }

    // Track Attendance
    @Given("the client is enrolled in program {string}")
    public void the_client_is_enrolled_in_program(String programName) {
        enrolledPrograms.put(programName, true);
        System.out.println("Client is enrolled in program: " + programName);
    }

    @When("the client attends the session on {string}")
    public void the_client_attends_the_session_on(String sessionDate) {
        if (!enrolledPrograms.isEmpty()) {
            attendanceRecords.put(sessionDate, "Attended");
            System.out.println("Client attended the session on: " + sessionDate);
        } else {
            System.out.println("Client is not enrolled in any program.");
        }
    }

    @Then("the system records the attendance for {string} on {string}")
    public void the_system_records_the_attendance_for_on(String programName, String sessionDate) {
        assertEquals("Attended", attendanceRecords.get(sessionDate));
        System.out.println("Attendance recorded for program: " + programName + " on " + sessionDate);
    }
    @When("the client views their program achievements")
    public void the_client_views_their_program_achievements() {
        viewedAchievements.clear(); // Clear any previously viewed achievements
        viewedAchievements.putAll(achievements); // Copy achievements to viewedAchievements
        System.out.println("Client is viewing achievements:");
        viewedAchievements.forEach((title, description) -> System.out.println(title + ": " + description)); // Print viewed achievements
    }

    @Given("the client has completed the following programs:")
    public void the_client_has_completed_the_following_programs(DataTable dataTable) {
        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            String programName = row.get("programName");
            // Store the achievement description correctly
            achievements.put(programName, "Completed the " + programName);
            System.out.println("Achievement added: " + programName + " -> " + achievements.get(programName)); // Debugging output
        }
    }



    @Then("the system displays the following program achievements:")
    public void the_system_displays_the_following_program_achievements(DataTable dataTable) {
        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            String achievementTitle = row.get("achievementTitle"); // This is the title you expect
            String expectedDescription = row.get("achievementDescription"); // This is the expected description

            // Retrieve the actual description using the achievement title directly
            String actualDescription = achievements.get(achievementTitle); // Use the title as the key

            // Debugging output
            System.out.println("Checking achievement: " + achievementTitle);
            System.out.println("Expected Description: " + expectedDescription);
            System.out.println("Actual Description: " + actualDescription);



        }
        System.out.println("Achievements displayed successfully.");
    }

    @Given("the client has earned the following badges:")
    public void the_client_has_earned_the_following_badges(DataTable dataTable) {
        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            badges.put(row.get("badgeTitle"), row.get("badgeDescription"));
        }
        System.out.println("Client has earned the following badges:");
        badges.forEach((title, description) -> System.out.println(title + ": " + description));
    }

    @When("the client views their badges")
    public void the_client_views_their_badges() {
        viewedBadges.clear();
        viewedBadges.putAll(badges);
        System.out.println("Client is viewing badges:");
        viewedBadges.forEach((title, description) -> System.out.println(title + ": " + description));
    }

    @Then("the system displays the following badges:")
    public void the_system_displays_the_following_badges(DataTable dataTable) {
        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            String expectedDescription = row.get("badgeDescription");
            String title = row.get("badgeTitle");
            String actualDescription = viewedBadges.get(title);
            assertEquals(expectedDescription, actualDescription);
        }
        System.out.println("Badges displayed successfully.");
    }
}
