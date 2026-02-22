package najah;

import java.util.Scanner;
import java.util.logging.Logger;

public abstract class BaseDashboard {
    protected static final Logger logger = Logger.getLogger(BaseDashboard.class.getName());
    public static final String ENTER_YOUR_CHOICE = "Enter your choice: ";
    public static final String INVALID_CHOICE_MESSAGE = "Invalid choice. Returning to dashboard.";

    protected int displayDashboardMenu(String title, String[] options, Scanner scanner) {
    // Check if INFO level logging is enabled before constructing log messages
        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.format("%n--- %s ---", title)); // Use formatting for clarity
            for (int i = 0; i < options.length; i++) {
                logger.info(String.format("%d. %s", i + 1, options[i]));
            }
            logger.info(ENTER_YOUR_CHOICE);
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }


    protected int displayManagementOptions(String title, String[] options, Scanner scanner) {
        if (logger.isLoggable(Level.INFO)) {
            logger.info(title);

            // Log the options
            for (int i = 0; i < options.length; i++) {
                logger.info(String.format("%d. %s", i + 1, options[i]));
            }

            // Prompt for user input
            logger.info(String.format("Please select an option (1-%d): ", options.length));
        }
        
        int choice = -1;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } else {
            scanner.nextLine(); // Consume the invalid input
            logger.warning("Invalid input. Please enter a number.");
        }

        return choice;
    }
}