package  najah.edu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class ProgramEnrollmentSteps {

    // Program model
    public static class Program {
        private String name;
        private String difficultyLevel;
        private String focusArea;
        private String schedule;

        public Program(String name, String difficultyLevel, String focusArea, String schedule) {
            this.name = name;
            this.difficultyLevel = difficultyLevel;
            this.focusArea = focusArea;
            this.schedule = schedule;
        }

        public String getName() {
            return name;
        }

        public String getDifficultyLevel() {
            return difficultyLevel;
        }

        public String getFocusArea() {
            return focusArea;
        }

        public String getSchedule() {
            return schedule;
        }
    }

    // Simulated database
    private List<Program> programs;
    private List<Program> displayedPrograms;
    private List<Program> enrolledPrograms;
    private String currentPage;

    public ProgramEnrollmentSteps() {
        // Initialize the simulated database with sample programs
        programs = new ArrayList<>();
        programs.add(new Program("Beginner Yoga", "Beginner", "Flexibility", "Mon, Wed, Fri - 10:00 AM"));
        programs.add(new Program("Intermediate Pilates", "Intermediate", "Muscle Building", "Tue, Thu - 11:00 AM"));
        programs.add(new Program("Advanced Bodybuilding", "Advanced", "Muscle Building", "Mon, Wed - 6:00 PM"));
        programs.add(new Program("Weight Loss Program", "Beginner", "Weight Loss", "Mon, Wed, Fri - 9:00 AM"));
        programs.add(new Program("Strength Training", "Intermediate", "Muscle Building", "Tue, Thu - 5:00 PM"));
        programs.add(new Program("Yoga for Beginners", "Beginner", "Flexibility", "Sat - 10:00 AM"));

        enrolledPrograms = new ArrayList<>();
    }

    @Given("the client is on the program enrollment page")
    public void the_client_is_on_the_program_enrollment_page() {
        currentPage = "program enrollment page";
        System.out.println("Client is on the " + currentPage);
    }

    @When("the client browses programs by difficulty level {string}")
    public void the_client_browses_programs_by_difficulty_level(String difficultyLevel) {
        // Fetch programs by difficulty level
        displayedPrograms = new ArrayList<>();
        for (Program program : programs) {
            if (program.getDifficultyLevel().equalsIgnoreCase(difficultyLevel)) {
                displayedPrograms.add(program);
            }
        }
        System.out.println("Client browsed programs with difficulty level: " + difficultyLevel);
    }

    @Then("the system displays programs with difficulty level {string}")
    public void the_system_displays_programs_with_difficulty_level(String difficultyLevel) {
        // Check if the displayed programs match the expected difficulty level
        assertTrue(displayedPrograms.stream().anyMatch(program -> program.getDifficultyLevel().equalsIgnoreCase(difficultyLevel)));
        System.out.println("Displayed programs for difficulty level: " + difficultyLevel);
    }

    @When("the client browses programs by focus area {string}")
    public void the_client_browses_programs_by_focus_area(String focusArea) {
        // Fetch programs by focus area
        displayedPrograms = new ArrayList<>();
        for (Program program : programs) {
            if (program.getFocusArea().equalsIgnoreCase(focusArea)) {
                displayedPrograms.add(program);
            }
        }
        System.out.println("Client browsed programs with focus area: " + focusArea);
    }

    @Then("the system displays programs with focus area {string}")
    public void the_system_displays_programs_with_focus_area(String focusArea) {
        // Check if the displayed programs match the expected focus area
        assertTrue(displayedPrograms.stream().anyMatch(program -> program.getFocusArea().equalsIgnoreCase(focusArea)));
        System.out.println("Displayed programs for focus area: " + focusArea);
    }

    @When("the client enrolls in program {string}")
    public void the_client_enrolls_in_program(String programName) {
        // Fetch the program by name and simulate the enrollment process
        for (Program program : programs) {
            if (program.getName().equalsIgnoreCase(programName)) {
                enrolledPrograms.add(program);
                System.out.println("Client enrolled in program: " + programName);
                return;
            }
        }
        System.out.println("Program not found: " + programName);
    }

    @Then("the system displays the schedule for program {string}")
    public void the_system_displays_the_schedule_for_program(String programName) {
        // Fetch the program by name to display the schedule
        for (Program program : programs) {
            if (program.getName().equalsIgnoreCase(programName)) {
                System.out.println("Displaying schedule for program: " + programName + " - " + program.getSchedule());
                return;
            }
        }
        System.out.println("Program not found: " + programName);
    }
}