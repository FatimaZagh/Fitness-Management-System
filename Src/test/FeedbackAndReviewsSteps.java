package najah.edu;


import io.cucumber.java.en.Given;


import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class FeedbackAndReviewsSteps {

    // Maps to store ratings, reviews, and suggestions
    private Map<String, Integer> programRatings = new HashMap<>();
    private Map<String, String> programReviews = new HashMap<>();
    private Map<String, String> improvementSuggestions = new HashMap<>();

    @Given("the client has completed the program {string}")
    public void the_client_has_completed_the_program(String programName) {
        // Simulate the completion of the program
        System.out.println("Client has completed the program: " + programName);
    }

    @When("the client rates the program with a score of {int}")
    public void the_client_rates_the_program_with_a_score_of(int score) {
        // Assume the program name is known in context; for simplicity, we can use a fixed name
        String programName = "Weight Loss Program"; // This should be dynamic in a real scenario
        programRatings.put(programName, score);
        System.out.println("Client rated the program " + programName + " with a score of " + score);
    }

    @Then("the system records the rating for {string} as {int}")
    public void the_system_records_the_rating_for_as(String programName, int expectedRating) {
        assertEquals((Integer) expectedRating, programRatings.get(programName));
        System.out.println("Rating recorded for " + programName + ": " + expectedRating);
    }

    @When("the client submits a review {string}")
    public void the_client_submits_a_review(String review) {
        // Assume the program name is known in context; for simplicity, we can use a fixed name
        String programName = "Strength Training"; // This should be dynamic in a real scenario
        programReviews.put(programName, review);
        System.out.println("Client submitted a review for " + programName + ": " + review);
    }

    @Then("the system records the review for {string}")
    public void the_system_records_the_review_for(String programName) {
        assertEquals("Great program, helped me build strength!", programReviews.get(programName));
        System.out.println("Review recorded for " + programName);
    }

    @When("the client submits an improvement suggestion {string}")
    public void the_client_submits_an_improvement_suggestion(String suggestion) {
        // Assume the program name is known in context; for simplicity, we can use a fixed name
        String programName = "Yoga for Beginners"; // This should be dynamic in a real scenario
        improvementSuggestions.put(programName, suggestion);
        System.out.println("Client submitted an improvement suggestion for " + programName + ": " + suggestion);
    }

    @Then("the system records the suggestion for {string}")
    public void the_system_records_the_suggestion_for(String programName) {
        assertEquals("Add more advanced poses.", improvementSuggestions.get(programName));
        System.out.println("Suggestion recorded for " + programName);
    }
}