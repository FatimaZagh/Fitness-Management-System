package najah;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    // Define constants for roles
    private static final String ROLE_ADMIN = "Admin";
    private static final String ROLE_INSTRUCTOR = "Instructor";
    private static final String ROLE_CLIENT = "Client"; // Optional for completeness

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Login process
        logger.info("Welcome to the Najah Management System!");
        logger.info("Please enter your email: ");
        String email = scanner.nextLine();
        logger.info("Please enter your password: ");
        String password = scanner.nextLine();

        // Attempt to login
        User user = loginUser (email, password);

        if (user == null) {
            logger.error("Invalid email or password.");
            return; // Exit the program if login fails
        }

        logger.info("Login successful!");

        // Step 2: Role selection process
        String role = selectRole(scanner);

        if (role == null) {
            logger.error("Invalid role selected.");
            return; // Exit if invalid role is selected
        }

        // Step 3: Security Key for role
        if (!validateSecurityKey(scanner, role)) {
            logger.error("Invalid security key. Access denied.");
            return; // Exit if security key is invalid
        }

        // Step 4: Show the corresponding dashboard
        if (role.equalsIgnoreCase(ROLE_ADMIN)) {
            AdminDashboard adminDashboard = new AdminDashboard(user);
            adminDashboard.showDashboard();
        } else if (role.equalsIgnoreCase(ROLE_INSTRUCTOR)) {
            InstructorDashboard instructorDashboard = new InstructorDashboard(user);
            instructorDashboard.showDashboard();
        } else if (role.equalsIgnoreCase(ROLE_CLIENT)) {
            ClientDashboard clientDashboard = new ClientDashboard(user);
            clientDashboard.showDashboard();
        } else {
            logger.error("Invalid role. Exiting.");
        }

        scanner.close();
    }

    // Method to handle user login
    private static User loginUser (String email, String password) {
        // Simulate user login (in a real-world case, this should query a database)
        // For simplicity, we create dummy users here
        if (email.equals("admin@example.com") && password.equals("admin123")) {
            return new User(ROLE_ADMIN, email, password, ROLE_ADMIN);
        } else if (email.equals("instructor@example.com") && password.equals("instructor123")) {
            return new User(ROLE_INSTRUCTOR, email, password, ROLE_INSTRUCTOR);
        } else if (email.equals("client@example.com") && password.equals("client123")) {
            return new User(ROLE_CLIENT, email, password, ROLE_CLIENT);
        }
        return null; // Return null if no match
    }

    // Method to handle role selection
    private static String selectRole(Scanner scanner) {
        logger.info("Please select your role:");
        logger.info("1. " + ROLE_ADMIN);
        logger.info("2. " + ROLE_INSTRUCTOR);
        logger.info("3. " + ROLE_CLIENT);

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                return ROLE_ADMIN;
            case 2:
                return ROLE_INSTRUCTOR;
            case 3:
                return ROLE_CLIENT;
            default:
                return null; // Invalid role choice
        }
    }

    // Method to validate the security key based on the role
    private static boolean validateSecurityKey(Scanner scanner, String role) {
        logger.info("Enter the security key for " + role + ":");
        String securityKey = scanner.nextLine();

        // Simulated security keys (replace with real implementation in production)
        if (role.equalsIgnoreCase(ROLE_ADMIN) && securityKey.equals("adminSecKey")) {
            return true;
        } else if (role .equalsIgnoreCase(ROLE_INSTRUCTOR) && securityKey.equals("instructorSecKey")) {
            return true;
        } else if (role.equalsIgnoreCase(ROLE_CLIENT) && securityKey.equals("clientSecKey")) {
            return true;
        }
        return false; // Invalid security key
    }
}