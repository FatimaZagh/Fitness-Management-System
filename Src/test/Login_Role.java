package najah.edu;

import java.util.HashMap;
import java.util.Map;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Role {
    private String errorMessage = "";

    private boolean isLoggedIn = false;
    private String userRole;
    private String adminPasscode = "admin123"; // Example passcode for admin
    private Map<String, String> validCredentials = new HashMap<>();

    public Login_Role() {
        // Initialize valid credentials for testing
        validCredentials.put("admin", "admin123");
        validCredentials.put("instructor", "instructor123");
        validCredentials.put("client", "client123");
    }

    // Scenario 1: User logs in with valid credentials and selects a role
    @Given("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        // Simulate navigation to the login page (e.g., printing a message)
        System.out.println("User is on the login page.");
    }

    @When("the user enters valid credentials \\(username and password)")
    public void the_user_enters_valid_credentials_username_and_password() {
        // Simulating entering valid credentials
        String username = "admin";
        String password = "admin123";
        
        if (validCredentials.containsKey(username) && validCredentials.get(username).equals(password)) {
            isLoggedIn = true;
            userRole = username;
            System.out.println("Login successful for user: " + username);
        } else {
            this.errorMessage = "Invalid username or password";  // Set the error message here
            throw new IllegalStateException(errorMessage);
        }
    }

    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String buttonName) {
        // Simulating clicking the login button
        if (buttonName.equals("Login")) {
            System.out.println("Login button clicked.");
        }
    }

    @Then("the system displays the role selection page")
    public void the_system_displays_the_role_selection_page() {
        if (isLoggedIn) {
            System.out.println("Displaying role selection page.");
        } else {
            throw new IllegalStateException("User must be logged in to see the role selection page.");
        }
    }

    @When("the user selects the {string} role")
    public void the_user_selects_the_role(String role) {
        if (isLoggedIn) {
            // Convert role to lowercase to match the code's role expectations
            userRole = role.toLowerCase(); // Set the user role (admin, instructor, client)
            System.out.println("User selected the role: " + role);
        } else {
            throw new IllegalStateException("User must be logged in to select a role.");
        }
    }
    
    @When("the user selects the {string} role   # Ensure this step sets the role to {string}")
    public void the_user_selects_the_role_ensure_this_step_sets_the_role_to(String selectedRole, String expectedRole) {
        // Set the user role to the selected role (ensure it matches lowercase in the code)
        userRole = selectedRole.toLowerCase();  // Store the role as lowercase
        
        // Validate that the role has been set correctly
        if (!userRole.equals(expectedRole)) {
            throw new IllegalStateException("Role was not set correctly. Expected: " + expectedRole + ", but got: " + userRole);
        }

        System.out.println("User role selected: " + userRole);  // Optional, to print the selected role
    }

    @Then("the system prompts the user to enter the admin passcode")
    public void the_system_prompts_the_user_to_enter_the_admin_passcode() {
        if ("admin".equals(userRole)) {
            System.out.println("Prompting for admin passcode...");
        } else {
            throw new IllegalStateException("Access denied: Only Admin can access this.");
        }
    }

    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        // Simulating entering invalid credentials
        String username = "admin";
        String password = "wrongpass";
        
        if (validCredentials.containsKey(username) && validCredentials.get(username).equals(password)) {
            isLoggedIn = true;
            userRole = username;
            System.out.println("Login successful for user: " + username);
        } else {
            this.errorMessage = "Invalid username or password";  // Set the error message for invalid login
            System.out.println(errorMessage); // Log the error message
        }
    }

    @Then("the system displays an error message: {string}")
    public void the_system_displays_an_error_message(String expectedMessage) {
        if (!errorMessage.equals(expectedMessage)) {
            throw new IllegalStateException("Expected error message: " + expectedMessage + ", but got: " + errorMessage);
        }
    }

    // Scenario 2: Admin role selection requires an additional admin passcode
    @Given("the user has logged in successfully as {string}  # Ensure user is logged in as admin")
    public void the_user_has_logged_in_successfully_as_ensure_user_is_logged_in_as_admin(String role) {
        if ("admin".equals(role)) {
            isLoggedIn = true;
            userRole = "admin";
            System.out.println("User has logged in successfully as admin.");
        } else {
            throw new IllegalStateException("User must log in as admin first.");
        }
    }

    @When("the user enters a valid admin passcode")
    public void the_user_enters_a_valid_admin_passcode() {
        // Simulate entering the valid admin passcode
        String enteredPasscode = "admin123";
        
        if (adminPasscode.equals(enteredPasscode)) {
            System.out.println("Admin passcode is valid.");
        } else {
            throw new IllegalStateException("Invalid admin passcode.");
        }
    }

    @Then("the system grants access to the Admin Dashboard")
    public void the_system_grants_access_to_the_admin_dashboard() {
        if ("admin".equals(userRole)) {
            System.out.println("Access granted to Admin Dashboard.");
        } else {
            throw new IllegalStateException("Access denied: Only Admin can access this.");
        }
    }

    @When("the user enters an invalid admin passcode")
    public void the_user_enters_an_invalid_admin_passcode() {
        // Simulate entering the invalid admin passcode
        String enteredPasscode = "wrongpass";
        
        // Check if the entered passcode is correct
        if (adminPasscode.equals(enteredPasscode)) {
            System.out.println("Admin passcode is valid.");
        } else {
            // Instead of throwing an exception, display the error message
            this.errorMessage = "Invalid admin passcode";
            System.out.println(errorMessage); // Log the error for validation in the test
        }
    }

    @Then("denies access to the Admin Dashboard")
    public void denies_access_to_the_admin_dashboard() {
        System.out.println("Access denied to the Admin Dashboard.");
    }
}
