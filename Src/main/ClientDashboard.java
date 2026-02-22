package najah;

import java.util.Scanner;
import java.util.logging.Logger;

public class ClientDashboard extends BaseDashboard {
    private static final Logger logger = Logger.getLogger(ClientDashboard.class.getName());
    private static final String ENTER_YOUR_CHOICE = "Enter your choice: ";
    private static final String INVALID_CHOICE_MESSAGE = "Invalid choice. Returning to dashboard.";
    private User clientUser ;

    public ClientDashboard(User clientUser ) {
        this.clientUser  = clientUser ;
    }

    public void showDashboard() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            String[] options = {
                    "Account Management",
                    "Program Exploration and Enrollment",
                    "Progress Tracking",
                    "Feedback and Reviews",
                    "Logout"
            };
            choice = displayDashboardMenu("Client Dashboard", options, scanner);
            switch (choice) {
                case 1:
                    manageAccount(scanner);
                    break;
                case 2:
                    exploreAndEnrollPrograms(scanner);
                    break;
                case 3:
                    trackProgress(scanner);
                    break;
                case 4:
                    provideFeedbackAndReviews(scanner);
                    break;
                case 5:
                    logger.info("Logging out... Goodbye!");
                    break;
                default:
                    logger.warning("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

private int displayOptions(String title, String[] options, Scanner scanner) {
    // Check if logging is enabled
    if (logger.isLoggable(Level.INFO)) {
        // Log the title
        logger.info(() -> String.format("%n--- %s ---", title));

        // Log each option
        for (int i = 0; i < options.length; i++) {
            final int index = i; // For lambda scoping
            logger.info(() -> String.format("%d. %s", index + 1, options[index]));
        }

        // Log the prompt
        logger.info(() -> ENTER_YOUR_CHOICE);
    }

    int choice = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character
    return choice;
}

    // Feature 1: Account Management
    private void manageAccount(Scanner scanner) {
        String[] options = {
                "Update Personal Details",
                "Update Dietary Preferences"
        };
        int choice = displayOptions("Account Management", options, scanner);
        switch (choice) {
            case 1:
                logger.info("Updating personal details...");
                // Implement logic for updating personal details
                break;
            case 2:
                logger.info("Updating dietary preferences...");
                // Implement logic for updating dietary preferences
                break;
            default:
                logger.warning(INVALID_CHOICE_MESSAGE);
        }
    }

    // Feature 2: Program Exploration and Enrollment
    private void exploreAndEnrollPrograms(Scanner scanner) {
        String[] options = {
                "Browse Programs",
                "Enroll in a Program",
                "View Enrolled Programs"
        };
        int choice = displayOptions("Program Exploration and Enrollment", options, scanner);
        switch (choice) {
            case 1:
                logger.info("Browsing available programs...");
                // Implement logic for browsing programs
                break;
            case 2:
                logger.info("Enrolling in a program...");
                // Implement logic for enrolling in a program
                break;
            case 3:
                logger.info("Viewing enrolled programs...");
                // Implement logic for displaying enrolled programs
                break;
            default:
                logger.warning(INVALID_CHOICE_MESSAGE);
        }
    }

    // Feature 3: Progress Tracking
    private void trackProgress(Scanner scanner) {
        String[] options = {
                "Track Fitness Milestones",
                "View Achievements and Badges"
        };
        int choice = displayOptions("Progress Tracking", options, scanner);
        switch (choice) {
            case 1:
                logger.info("Tracking fitness milestones...");
                // Implement logic for tracking fitness milestones
                break;
            case 2:
                logger.info("Viewing achievements and badges...");
                // Implement logic for viewing achievements and badges
                break;
            default:
                logger.warning(INVALID_CHOICE_MESSAGE);
        }
    }

    // Feature 4: Feedback and Reviews
    private void provideFeedbackAndReviews(Scanner scanner) {
        String[] options = {
                "Rate and Review Completed Programs",
                "Submit Improvement Suggestions"
        };
        int choice = displayOptions("Feedback and Reviews", options, scanner);
        switch (choice) {
            case 1:
                logger.info("Rating and reviewing completed programs...");
                // Implement logic for rating and reviewing programs
                break;
            case 2:
                logger.info("Submitting improvement suggestions...");
                // Implement logic for submitting improvement suggestions
                break;
            default:
                logger.warning(INVALID_CHOICE_MESSAGE);
        }
    }
}