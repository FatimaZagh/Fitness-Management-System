Feature: User Management
  Purpose: Covers all actions related to user accounts by the admin.

  Background:
    Given the admin is on the User Management page

  Scenario: Admin adds a new instructor account with valid details
    When the admin clicks "Add Instructor"
    And the admin provides valid details (name, email, password)
    Then the system creates a new instructor account
    And displays a success message: "Instructor account added successfully"

  Scenario: Admin adds a new client account with valid details
    When the admin clicks "Add Client"
    And the admin provides valid details (name, email, password)
    Then the system creates a new client account
    And displays a success message: "Client account added successfully"

  Scenario: Admin updates existing user account information
    Given the system has an existing client account
    When the admin selects a user account to update
    And updates the required details
    Then the system updates the user account successfully

  Scenario: Admin deactivates an inactive or misbehaving user account
    Given the system has an existing instructor account
    When the admin selects a user account to deactivate
    Then the system deactivates the account
    And displays a message: "User account deactivated successfully"

  Scenario: Admin approves or rejects pending instructor registration requests
    When the admin views pending instructor registration requests
    Then the admin approves or rejects the requests
    And the system updates the status accordingly

  Scenario: Admin views engagement statistics
    When the admin selects the "View Engagement Statistics" option
    Then the system displays statistics such as login frequency and program enrollments
