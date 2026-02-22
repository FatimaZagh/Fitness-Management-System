package najah;

import java.util.HashMap;
import java.util.Map;

public class FeedbackService {

    private Map<Integer, Feedback> feedbackDatabase = new HashMap<>();
    private int feedbackIdCounter = 1;

    // Add new feedback
    public int addFeedback(String message, String submittedBy) {
        Feedback feedback = new Feedback(feedbackIdCounter, message, submittedBy, null);
        feedbackDatabase.put(feedbackIdCounter, feedback);
        return feedbackIdCounter++;
    }

    // Respond to feedback
    public void respondToFeedback(int feedbackId, String response) {
        Feedback feedback = feedbackDatabase.get(feedbackId);
        if (feedback != null) {
            feedback.setResponse(response);
        }
    }

    // Retrieve feedback by ID
    public Feedback getFeedback(int feedbackId) {
        return feedbackDatabase.get(feedbackId);
    }
}