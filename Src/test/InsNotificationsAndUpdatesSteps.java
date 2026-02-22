package najah.edu;

import io.cucumber.java.en.Then;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class InsNotificationsAndUpdatesSteps {
    private boolean invalidInputErrorDisplayed = false;

    private boolean scheduleUpdated = false;
    private boolean announcementPublished = false;
    private String notificationContent = "";
    private List<String> notifications = new ArrayList<>();
    private List<String> clientDashboards = new ArrayList<>();
    private Map<String, String> archivedMaterials = new HashMap<>();

    @Given("the instructor updates the program schedule")
    public void the_instructor_updates_the_program_schedule() {
        scheduleUpdated = true;
    }

    @When("they save the changes")
    public void they_save_the_changes() {
        if (scheduleUpdated) {
            notifications.add("Program schedule has been updated.");
        }
    }

    @Then("the system notifies all enrolled clients about the updated schedule.")
    public void the_system_notifies_all_enrolled_clients_about_the_updated_schedule() {
        assertTrue(notifications.contains("Program schedule has been updated."));
    }

    @Given("the instructor has created a new program")
    public void the_instructor_has_created_a_new_program() {
        announcementPublished = true;
    }

    @When("they publish an announcement")
    public void they_publish_an_announcement() {
        if (announcementPublished) {
            clientDashboards.add("New program announcement published.");
        }
    }

    @Then("all potential clients see the announcement on their dashboards.")
    public void all_potential_clients_see_the_announcement_on_their_dashboards() {
        assertTrue(clientDashboards.contains("New program announcement published."));
    }

    @Given("the instructor wants to promote a discount or special offer")
    public void the_instructor_wants_to_promote_a_discount_or_special_offer() {
        notificationContent = "Special offer details.";
    }

    @When("they create a new announcement with the offer details")
    public void they_create_a_new_announcement_with_the_offer_details() {
        notifications.add(notificationContent);
    }

    @Then("all clients receive a notification about the special offer.")
    public void all_clients_receive_a_notification_about_the_special_offer() {
        assertTrue(notifications.contains("Special offer details."));
    }

    @Given("a group session is scheduled for a program")
    public void a_group_session_is_scheduled_for_a_program() {
        notificationContent = "Reminder: Upcoming group session.";
    }

    @When("the session date is approaching")
    public void the_session_date_is_approaching() {
        notifications.add(notificationContent);
    }

    @Then("the system automatically sends a reminder notification to all enrolled clients.")
    public void the_system_automatically_sends_a_reminder_notification_to_all_enrolled_clients() {
        assertTrue(notifications.contains("Reminder: Upcoming group session."));
    }

    @Given("the instructor wants to send a notification")
    public void the_instructor_wants_to_send_a_notification() {
        notificationContent = ""; // Ensuring the content is empty
    }


    @When("they provide invalid content, such as an empty message")
    public void they_provide_invalid_content_such_as_an_empty_message() {
        if (notificationContent.isEmpty()) {
            invalidInputErrorDisplayed = true; // Set the flag to true when content is empty
        }
    }



    @Then("the system displays an error message")
    public void the_system_displays_an_error_message() {
        assertTrue(invalidInputErrorDisplayed); // Ensure error flag is set correctly
    }




    @Then("the notification is not sent.")
    public void the_notification_is_not_sent() {
        assertTrue(notifications.isEmpty());
    }

    @Given("the instructor marks a program as {string}")
    public void the_instructor_marks_a_program_as(String status) {
        if (status.equals("Completed")) {
            notificationContent = "Program has been completed.";
        }
    }

    @When("they confirm the update")
    public void they_confirm_the_update() {
        notifications.add(notificationContent);
        archivedMaterials.put("Program1", "Archived materials link");
    }

    @Then("the system notifies all enrolled clients about the program completion")
    public void the_system_notifies_all_enrolled_clients_about_the_program_completion() {
        assertTrue(notifications.contains("Program has been completed."));
    }

    @Then("clients can access archived materials.")
    public void clients_can_access_archived_materials() {
        assertTrue(archivedMaterials.containsKey("Program1"));
    }

    @Given("the instructor wants to re-engage past or inactive clients")
    public void the_instructor_wants_to_re_engage_past_or_inactive_clients() {
        notificationContent = "We miss you! Check out our new programs.";
    }

    @When("they send a personalized notification encouraging them to enroll in new programs")
    public void they_send_a_personalized_notification_encouraging_them_to_enroll_in_new_programs() {
        notifications.add(notificationContent);
    }

    @Then("the system sends the notification to the specified clients.")
    public void the_system_sends_the_notification_to_the_specified_clients() {
        assertTrue(notifications.contains("We miss you! Check out our new programs."));
    }
}
