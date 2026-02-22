package najah.edu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import najah.User;

public class User_mang {
	
	
    private Map<String, User> userAccounts = new HashMap<>();
    private List<String> pendingInstructorRequests = new ArrayList<>();
    private User selectedUser;
    private String adminPage;

    @Given("the admin is on the User Management page")
    public void the_admin_is_on_the_user_management_page() {
        adminPage = "User Management";
        System.out.println("Admin is on the User Management page.");
    }

    @When("the admin clicks {string}")
    public void the_admin_clicks(String action) {
        System.out.println("Admin clicked: " + action);
    }

    @When("the admin provides valid details \\(name, email, password)")
    public void the_admin_provides_valid_details_name_email_password() {
        System.out.println("Admin is providing valid details...");
    }

    @Then("the system creates a new instructor account")
    public void the_system_creates_a_new_instructor_account() {
        User instructor = new User("Instructor Name", "instructor@example.com", "password123", "Instructor");
        userAccounts.put(instructor.getEmail(), instructor);
        System.out.println("Instructor account added successfully: " + instructor);
    }

    @Then("the system creates a new client account")
    public void the_system_creates_a_new_client_account() {
        User client = new User("Client Name", "client@example.com", "password123", "Client");
        userAccounts.put(client.getEmail(), client);
        System.out.println("Client account added successfully: " + client);
    }
    
    @Given("the system has an existing client account")
    public void the_system_has_an_existing_client_account() {
        User client = new User("Client Name", "client@example.com", "password123", "Client");
        userAccounts.put(client.getEmail(), client);
        System.out.println("Existing client account added: " + client);
    }

    
    @Given("the system has an existing instructor account")
    public void the_system_has_an_existing_instructor_account() {
        User instructor = new User("Instructor Name", "instructor@example.com", "password123", "Instructor");
        userAccounts.put(instructor.getEmail(), instructor);
        System.out.println("Existing instructor account added: " + instructor);
    }


    @When("the admin selects a user account to update")
    public void the_admin_selects_a_user_account_to_update() {
        selectedUser = userAccounts.get("client@example.com"); // Example: selecting a client
        if (selectedUser == null) {
            throw new IllegalStateException("User not found.");
        }
        System.out.println("Selected user: " + selectedUser);
    }

    @When("updates the required details")
    public void updates_the_required_details() {
        if (selectedUser != null) {
            selectedUser.setName("Updated Name");
            System.out.println("User details updated to: " + selectedUser);
        } else {
            throw new IllegalStateException("No user selected for update.");
        }
    }

    @Then("the system updates the user account successfully")
    public void the_system_updates_the_user_account_successfully() {
        System.out.println("User account updated successfully.");
    }

    @When("the admin selects a user account to deactivate")
    public void the_admin_selects_a_user_account_to_deactivate() {
        selectedUser = userAccounts.get("instructor@example.com"); // Example: selecting an instructor
        if (selectedUser == null) {
            throw new IllegalStateException("User not found.");
        }
        System.out.println("Selected user for deactivation: " + selectedUser);
    }

    @Then("the system deactivates the account")
    public void the_system_deactivates_the_account() {
        if (selectedUser != null) {
            selectedUser.setActive(false);
            System.out.println("User account deactivated: " + selectedUser);
        } else {
            throw new IllegalStateException("No user selected for deactivation.");
        }
    }

    @Then("displays a message: {string}")
    public void displays_a_message(String message) {
        System.out.println(message);
    }

    @When("the admin views pending instructor registration requests")
    public void the_admin_views_pending_instructor_registration_requests() {
        pendingInstructorRequests.add("Instructor Request 1");
        pendingInstructorRequests.add("Instructor Request 2");
        System.out.println("Pending instructor registration requests: " + pendingInstructorRequests);
    }

    @Then("the admin approves or rejects the requests")
    public void the_admin_approves_or_rejects_the_requests() {
        pendingInstructorRequests.clear();
        System.out.println("All instructor registration requests processed.");
    }

    @Then("the system updates the status accordingly")
    public void the_system_updates_the_status_accordingly() {
        System.out.println("Instructor registration statuses updated.");
    }

    @When("the admin selects the {string} option")
    public void the_admin_selects_the_option(String option) {
        System.out.println("Admin selected the option: " + option);
    }

    @Then("the system displays statistics such as login frequency and program enrollments")
    public void the_system_displays_statistics_such_as_login_frequency_and_program_enrollments() {
        System.out.println("Displaying user engagement statistics:");
        System.out.println("Login frequency: High");
        System.out.println("Program enrollments: 150 active users");
    }
}
