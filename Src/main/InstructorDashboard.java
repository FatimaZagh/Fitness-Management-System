package najah;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class InstructorDashboard extends BaseDashboard {
    private static final Logger logger = LoggerFactory.getLogger(InstructorDashboard.class);
    private User instructorUser ;

    public InstructorDashboard(User instructorUser ) {
        this.instructorUser  = instructorUser ;
    }

    public void showDashboard() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            String[] options = {
                    "Program Management",
                    "Client Interaction",
                    "Progress Tracking",
                    "Notifications and Updates",
                    "Logout"
            };
            choice = displayDashboardMenu("Instructor Dashboard", options, scanner);
            switch (choice) {
                case 1:
                    managePrograms(scanner);
                    break;
                case 2:
                    interactWithClients(scanner);
                    break;
                case 3:
                    trackClientProgress(scanner);
                    break;
                case 4:
                    handleNotifications(scanner);
                    break;
                case 5:
                    logger.info("Logging out... Goodbye!");
                    break;
                default:
                    logger.warn(INVALID_CHOICE_MESSAGE);
            }
        } while (choice != 5);
    }

    // Generic method to display options and get user choice
    private int displayOptions(String title, String[] options, Scanner scanner) {
        logger.info("\n--- " + title + " ---");
        for (int i = 0; i < options.length; i++) {
            logger.info((i + 1) + ". " + options[i]);
        }
        logger.info(ENTER_YOUR_CHOICE);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }

    // Feature 1: Program Management
    private void managePrograms(Scanner scanner) {
        String[] options = {
                "Create a New Program",
                "Update an Existing Program",
                "Delete a Program",
                "Set Schedules for Group Sessions"
        };
        int choice = displayOptions("Program Management", options, scanner);
        switch (choice) {
            case 1:
                logger.info("Creating a new program...");
                // Implement logic for creating a new program
                break;
            case 2:
                logger.info("Updating an existing program...");
                // Implement logic for updating a program
                break;
            case 3:
                logger.info("Deleting a program...");
                // Implement logic for deleting a program
                break;
            case 4:
                logger.info("Setting schedules for group sessions...");
                // Implement logic for setting schedules
                break;
            default:
                logger.warn(INVALID_CHOICE_MESSAGE);
        }
    }

    // Feature 2: Client Interaction
    private void interactWithClients(Scanner scanner) {
        String[] options = {
                "Communicate with Clients",
                "Provide Feedback or Progress Reports"
        };
        int choice = displayOptions("Client Interaction", options, scanner);
        switch (choice) {
            case 1:
                logger.info("Communicating with clients...");
                // Implement logic for messaging or discussion forums
                break;
            case 2:
                logger.info("Providing feedback or progress reports...");
                // Implement logic for providing feedback
                break;
            default:
                logger.warn(INVALID_CHOICE_MESSAGE);
        }
    }

    // Feature 3: Progress Tracking
    private void trackClientProgress(Scanner scanner) {
        String[] options = {
                "Monitor Client Progress",
                "Send Motivational Reminders or Recommendations"
        };
        int choice = displayOptions("Progress Tracking", options, scanner);
        switch (choice) {
            case 1:
                logger.info("Monitoring client progress...");
                // Implement logic for monitoring client progress
                break;
            case 2:
                logger.info("Sending motivational reminders or recommendations...");
                // Implement logic for sending reminders
                break;
            default:
                logger.warn(INVALID_CHOICE_MESSAGE);
        }
    }

    // Feature 4: Notifications and Updates
    private void handleNotifications(Scanner scanner) {
        String[] options = {
                "Notify Clients about Schedule Changes",
                "Announce New Programs or Special Offers"
        };
        int choice = displayOptions("Notifications and Updates", options, scanner);
        switch (choice) {
            case 1:
                logger.info("Notifying clients about schedule changes...");
                // Implement logic for notifying clients
                break;
            case 2:
                logger.info("Announcing new programs or special offers...");
                // Implement logic for announcements
                break;
            default:
                logger.warn(INVALID_CHOICE_MESSAGE);
        }
    }
}