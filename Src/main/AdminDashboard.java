package najah;

import java.util.Scanner;
import java.util.logging.Logger;

public class AdminDashboard extends BaseDashboard {
    private static final Logger logger = Logger.getLogger(AdminDashboard.class.getName());
    private User adminUser ;

    public AdminDashboard(User adminUser ) {
        this.adminUser  = adminUser ;
    }

    public void showDashboard() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            String[] options = {
                    "User  Management",
                    "Program Monitoring",
                    "Content Management",
                    "Subscription Management",
                    "Logout"
            };
            choice = displayDashboardMenu("Admin Dashboard", options, scanner);
            switch (choice) {
                case 1:
                    manageUsers(scanner);
                    break;
                case 2:
                    monitorPrograms(scanner);
                    break;
                case 3:
                    manageContent(scanner);
                    break;
                case 4:
                    logger.info("Logging out... Goodbye!");
                    break;
                default:
                    logger.warning(INVALID_CHOICE_MESSAGE);
            }
        } while (choice != 4);
    }

    // Feature 1: User Management
    private void manageUsers(Scanner scanner) {
        String[] options = {
                "Add User", "Update User", "Deactivate User", "Approve New Instructor", "Monitor User Activity"
        };
        String[] actions = {
                "Adding a new user...",
                "Updating a user...",
                "Deactivating a user...",
                "Approving new instructor registration...",
                "Monitoring user activity and engagement..."
        };
        executeManagementOptions("User  Management", options, actions, scanner);
    }

    // Feature 2: Program Monitoring
    private void monitorPrograms(Scanner scanner) {
        String[] options = {
                "View Most Popular Programs", "Generate Revenue and Attendance Reports", "Track Active and Completed Programs"
        };
        String[] actions = {
                "Viewing most popular programs...",
                "Generating revenue and attendance reports...",
                "Tracking active and completed programs..."
        };
        executeManagementOptions("Program Monitoring", options, actions, scanner);
    }

    // Feature 3: Content Management
    private void manageContent(Scanner scanner) {
        String[] options = {
                "Approve/Reject Wellness Articles", "Approve Health and Wellness Tips", "Handle User Feedback and Complaints"
        };
        String[] actions = {
                "Approving or rejecting wellness articles...",
                "Approving health and wellness tips...",
                "Handling user feedback and complaints..."
        };
        executeManagementOptions("Content Management", options, actions, scanner);
    }

// Generic method to execute management options
private void executeManagementOptions(String title, String[] options, String[] actions, Scanner scanner) {
    int choice = displayManagementOptions(title, options, scanner);
    if (choice >= 1 && choice <= actions.length) {
        if (logger.isLoggable(java.util.logging.Level.INFO)) {
            logger.info(String.format("Selected action: %s", actions[choice - 1]));
        }
    } else {
        logger.warning(INVALID_CHOICE_MESSAGE);
    }
}

}