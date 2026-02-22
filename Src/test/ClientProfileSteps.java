package najah.edu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertEquals;

public class ClientProfileSteps {

    private String name;
    private String age;
    private String fitnessGoal;
    private String dietaryPreference;
    private String profileMessage; // Message for profile updates
    private String dietaryMessage; // Message for dietary preferences
    private boolean isLoggedIn = false; // Simulate login status

    @Given("the client is on the profile management page")
    public void the_client_is_on_the_profile_managementpage() {
        // Code to navigate to the profile management page
        System.out.println("Navigated to profile management page.");
    }

    @When("the client enters their details with name {string}, age {string}, fitness goal {string}, and dietary preference {string}")
    public void the_client_enters_their_details(String name, String age, String fitnessGoal, String dietaryPreference) {
        this.name = name;
        this.age = age;
        this.fitnessGoal = fitnessGoal;
        this.dietaryPreference = dietaryPreference;
        // Code to enter client details
        System.out.println("Entered details: " + name + ", " + age + ", " + fitnessGoal + ", " + dietaryPreference);
    }

    @When("the client clicks on the save button")
    public void the_client_clicks_on_the_save_button() {
        // Code to simulate saving the profile
        profileMessage = "Profile updated successfully!";
        System.out.println("Profile saved.");
    }

    @Then("the system shows a message {string}")
    public void the_system_shows_a_message(String expectedMessage) {
        dietaryMessage="Dietary preferences updated successfully!";
        System.out.println("Displayed message: " +dietaryMessage );
    }

    @Given("the client is logged in")
    public void the_client_is_logged_in() {
        isLoggedIn = true; // Simulate login
        System.out.println("Client is logged in.");
    }

    @When("the client views their profile")
    public void the_client_views_their_profile() {
        // Code to simulate viewing the profile
        if (isLoggedIn) {
            System.out.println("Viewing profile for: " + name);
        } else {
            System.out.println("Client is not logged in.");
        }
    }

    @Then("the system displays the following details:")
    public void the_system_displays_the_following_details(DataTable dataTable) {
        // Code to verify displayed details
        System.out.println("Displaying profile details:");
        dataTable.asLists().forEach(row -> {
            System.out.println("Name: " + row.get(0) + ", Age: " + row.get(1) + ", Fitness Goal: " + row.get(2) + ", Dietary Preference: " + row.get(3));
        });
    }

    @When("the client adds dietary preferences or restrictions {string}")
    public void the_client_adds_dietary_preferences_or_restrictions(String dietaryPreference) {
        this.dietaryPreference = dietaryPreference;
        // Code to simulate adding dietary preferences
        dietaryMessage = "Dietary preferences updated successfully!"; // Use separate message
        System.out.println("Added dietary preference: " + dietaryPreference);
    }

    @Then("the system shows a dietary message {string}")
    public void the_system_shows_a_dietary_message(String expectedMessage) {
        assertEquals(expectedMessage, dietaryMessage);
        System.out.println("Displayed dietary message: " + dietaryMessage);
    }

    @Given("the client is on the profile creation page")
    public void the_client_is_on_the_profile_creationpage() {
        // Code to navigate to the profile creation page
        System.out.println("Navigated to profile creation page.");
    }

    @When("the client clicks on the create button")
    public void the_client_clicks_on_the_create_button() {
        // Code to simulate creating a new profile
        profileMessage = "Profile created successfully!";
        System.out.println("Profile created.");
    }


    @Given("the client is logged")
    public void the_client_is_logged() {
        isLoggedIn = true; // Simulate login
        System.out.println("Client is logged in.");
    }

    @When("the client views their dietary preferences")
    public void the_client_views_their_dietary_preferences() {
        // Code to simulate viewing dietary preferences
        if (isLoggedIn) {
            System.out.println("Viewing dietary preferences for: " + name);
        } else {
            System.out.println("Client is not logged in.");
        }
    }

    @Then("the system displays the following dietary preferences:")
    public void the_system_displays_the_following_dietarypreferences(DataTable dataTable) {
        // Code to verify displayed dietary preferences
        System.out.println("Displaying dietary preferences:");
        dataTable.asLists().forEach(row -> {
            System.out.println("Dietary Preference: " + row.get(0));
        });
    }
}