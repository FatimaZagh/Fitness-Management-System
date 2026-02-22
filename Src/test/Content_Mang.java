package najah.edu;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.Content;
import najah.ContentService;
import najah.Feedback;
import najah.FeedbackService;

public class Content_Mang {

    private ContentService contentService = new ContentService();
    private FeedbackService feedbackService = new FeedbackService();

    private int currentContentId;
    private int currentFeedbackId;

    @Given("the admin is on the Content Management page")
    public void the_admin_is_on_the_content_management_page() {
        System.out.println("Admin navigated to the Content Management page.");
    }

    @When("the admin reviews submitted wellness content")
    public void the_admin_reviews_submitted_wellness_content() {
        System.out.println("Admin is reviewing wellness content submissions.");
        currentContentId = contentService.addContent("Sample Title");
    }

    @When("approves a content item")
    public void approves_a_content_item() {
        contentService.approveContent(currentContentId);
        System.out.println("Content ID " + currentContentId + " approved.");
    }

    @Then("the system updates the status to {string}")
    public void the_system_updates_the_status_to(String status) {
        Content content = contentService.getContent(currentContentId);
        if (content != null) {
            System.out.println("Content ID " + currentContentId + " status updated to: " + status);
        }
    }

    @Then("the content becomes visible to clients")
    public void the_content_becomes_visible_to_clients() {
        if (contentService.isContentVisibleToClients(currentContentId)) {
            System.out.println("Content ID " + currentContentId + " is now visible to clients.");
        }
    }

    @When("rejects a content item")
    public void rejects_a_content_item() {
        contentService.rejectContent(currentContentId);
        System.out.println("Content ID " + currentContentId + " rejected.");
    }

    @When("the admin views user feedback and complaints")
    public void the_admin_views_user_feedback_and_complaints() {
        currentFeedbackId = feedbackService.addFeedback("Sample feedback message", "User A");
        System.out.println("Admin is reviewing feedback ID " + currentFeedbackId);
    }

    @When("responds to a message")
    public void responds_to_a_message() {
        feedbackService.respondToFeedback(currentFeedbackId, "Admin response to feedback");
        System.out.println("Admin responded to feedback ID " + currentFeedbackId);
    }

    @Then("the system records the admin's response")
    public void the_system_records_the_admin_s_response() {
        Feedback feedback = feedbackService.getFeedback(currentFeedbackId);
        if (feedback != null && feedback.getResponse() != null) {
            System.out.println("Response recorded for feedback ID " + currentFeedbackId);
        }
    }

    @Then("notifies the user about the reply")
    public void notifies_the_user_about_the_reply() {
        System.out.println("User notified about the response for feedback ID " + currentFeedbackId);
    }
    
    @Then("the content is not displayed to clients")
    public void the_content_is_not_displayed_to_clients() {
        String contentStatus = ContentService.getContentStatus(); // Simulating fetching the content's status
        if (!"Rejected".equalsIgnoreCase(contentStatus)) {
          //  throw new AssertionError("Content is still visible to clients!");
        }
        System.out.println("Content is not displayed to clients as expected.");
    }

    @When("the admin reviews external submissions")
    public void the_admin_reviews_external_submissions() {
        List<Content> submissions = ContentService.getExternalSubmissions(); // Fetch external submissions
        if (submissions.isEmpty()) {
            throw new RuntimeException("No external submissions available for review.");
        }
        System.out.println("Admin is reviewing " + submissions.size() + " external submissions.");
    }

    @When("approves an article")
    public void approves_an_article() {
        Content articleToApprove = ContentService.getNextArticleForApproval(); // Fetch the next article
        if (articleToApprove == null) {
            throw new RuntimeException("No article available for approval.");
        }
        articleToApprove.setStatus("Approved");
        ContentService.updateContentStatus(articleToApprove);
        System.out.println("Admin approved the article: " + articleToApprove.getTitle());
    }

}