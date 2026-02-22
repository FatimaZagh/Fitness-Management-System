package najah;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ContentService {

    private static final Logger logger = LoggerFactory.getLogger(ContentService.class);
    public static final String CONTENT_STATUS = "";

    private static List<Content> contentDatabase = new ArrayList<>();
    private static List<Content> externalSubmissions = new ArrayList<>();

    static {
        // Mock database entries
        contentDatabase.add(new Content("Instructor Wellness Tip #1"));
        externalSubmissions.add(new Content("External Contributor: Fitness Article #1"));
    }

    public static final String CONTENT_STATUS_REJECTED = "Rejected";

    public static List<Content> getExternalSubmissions() {
        return new ArrayList<>(externalSubmissions); // Return mock submissions
    }

    public static Content getNextArticleForApproval() {
        if (!externalSubmissions.isEmpty()) {
            return externalSubmissions.remove(0); // Remove and return the next article
        }
        return null;
    }

    public static void updateContentStatus(Content content) {
        contentDatabase.add(content); // Add to the database with updated status
        logger.info("Content status updated for: {}", content.getTitle());
    }

    public int addContent(String title ) {
        Content newContent = new Content(title);
        contentDatabase.add(newContent);
        logger.info("Content added: {}", title);
        return contentDatabase.size() - 1; // Return the index as the content ID
    }

    public boolean isContentVisibleToClients(int contentId) {
        if (contentId >= 0 && contentId < contentDatabase.size()) {
            Content content = contentDatabase.get(contentId);
            return "Approved".equalsIgnoreCase(content.getStatus());
        }
        logger.error("Invalid content ID: {}", contentId);
        return false;
    }

    public Content getContent(int contentId) {
        if (contentId >= 0 && contentId < contentDatabase.size()) {
            return contentDatabase.get(contentId);
        }
        logger.error("Invalid content ID: {}", contentId);
        return null;
    }

    public void approveContent(int contentId) {
        Content content = getContent(contentId);
        if (content != null) {
            content.setStatus("Approved");
            logger.info("Content approved: {}", content.getTitle());
        } else {
            logger.error("Cannot approve content. Content ID not found: {}", contentId);
        }
    }

    public void rejectContent(int currentContentId) {
        Content content = getContent(currentContentId);
        if (content != null) {
            content.setStatus(CONTENT_STATUS_REJECTED);
            logger.info("Content rejected: {}", content.getTitle());
        } else {
            logger.error("Cannot reject content. Content ID not found: {}", currentContentId);
        }
    }

    public static String getContentStatus() {
        return CONTENT_STATUS;
    }
}