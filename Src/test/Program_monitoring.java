package najah.edu;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program_monitoring {
    private String adminPage;
    private String selectedOption;
    private List<String> programStatistics = new ArrayList<>();
    private Map<String, Double> revenueReport = new HashMap<>();
    private List<String> attendanceReport = new ArrayList<>();
    private Map<String, String> clientProgressReport = new HashMap<>();
    private List<String> activePrograms = new ArrayList<>();
    private List<String> completedPrograms = new ArrayList<>();

    @Given("the admin is on the Program Monitoring page")
    public void the_admin_is_on_the_program_monitoring_page() {
        adminPage = "Program Monitoring";
        System.out.println("Admin is on the Program Monitoring page.");
    }

    @When("the admin selects {string}")
    public void the_admin_selects(String option) {
        selectedOption = option;
        System.out.println("Admin selected: " + option);
    }

    @Then("the system displays statistics for all programs")
    public void the_system_displays_statistics_for_all_programs() {
        if ("View Enrollment Statistics".equals(selectedOption)) {
            programStatistics.add("Program A: 50 participants");
            programStatistics.add("Program B: 30 participants");
            programStatistics.add("Program C: 20 participants");
            System.out.println("Statistics for all programs:");
            programStatistics.forEach(System.out::println);
        } else {
            throw new IllegalStateException("Invalid option selected for enrollment statistics.");
        }
    }

    @Then("the system generates and displays a detailed revenue report")
    public void the_system_generates_and_displays_a_detailed_revenue_report() {
        if ("Generate Revenue Report".equals(selectedOption)) {
            revenueReport.put("Program A", 5000.0);
            revenueReport.put("Program B", 3000.0);
            revenueReport.put("Program C", 2000.0);
            System.out.println("Revenue Report:");
            revenueReport.forEach((program, revenue) -> 
                System.out.println(program + ": $" + revenue));
        } else {
            throw new IllegalStateException("Invalid option selected for revenue report.");
        }
    }

    @Then("the system generates and displays an attendance report")
    public void the_system_generates_and_displays_an_attendance_report() {
        if ("Generate Attendance Report".equals(selectedOption)) {
            attendanceReport.add("Program A: 90% attendance");
            attendanceReport.add("Program B: 85% attendance");
            attendanceReport.add("Program C: 75% attendance");
            System.out.println("Attendance Report:");
            attendanceReport.forEach(System.out::println);
        } else {
            throw new IllegalStateException("Invalid option selected for attendance report.");
        }
    }

    @Then("the system generates and displays a detailed client progress report")
    public void the_system_generates_and_displays_a_detailed_client_progress_report() {
        if ("Generate Client Progress Report".equals(selectedOption)) {
            clientProgressReport.put("Client 1", "Lost 5kg, improved stamina");
            clientProgressReport.put("Client 2", "Gained 2kg muscle, improved flexibility");
            clientProgressReport.put("Client 3", "Reduced BMI by 2 points");
            System.out.println("Client Progress Report:");
            clientProgressReport.forEach((client, progress) -> 
                System.out.println(client + ": " + progress));
        } else {
            throw new IllegalStateException("Invalid option selected for client progress report.");
        }
    }

    @Then("the system displays a list of active and completed programs")
    public void the_system_displays_a_list_of_active_and_completed_programs() {
        if ("Track Active and Completed Programs".equals(selectedOption)) {
            activePrograms.add("Program A");
            activePrograms.add("Program B");
            completedPrograms.add("Program C");
            completedPrograms.add("Program D");
            System.out.println("Active Programs:");
            activePrograms.forEach(System.out::println);
            System.out.println("Completed Programs:");
            completedPrograms.forEach(System.out::println);
        } else {
            throw new IllegalStateException("Invalid option selected for tracking programs.");
        }
    }
}
