Feature: Login and Role Selection
  // Purpose: Handles user login and role selection.

  Scenario: User logs in with valid credentials and selects a role
    Given the user navigates to the login page
    When the user enters valid credentials (username and password)
    And the user clicks the "Login" button
    Then the system displays the role selection page
    When the user selects the "Admin" role   # Ensure this step sets the role to "admin"
    Then the system prompts the user to enter the admin passcode

  Scenario: User enters invalid credentials and sees an error message
    Given the user navigates to the login page
    When the user enters invalid credentials
    And the user clicks the "Login" button
    Then the system displays an error message: "Invalid username or password"
  
  Scenario: Admin role selection requires an additional admin passcode
    Given the user has logged in successfully as "admin"  # Ensure user is logged in as admin 
    When the user selects the "Admin" role
    Then the system prompts the user to enter the admin passcode
    When the user enters a valid admin passcode
    Then the system grants access to the Admin Dashboard

  Scenario: Invalid admin passcode denies access to the Admin Dashboard
    Given the user has logged in successfully as "admin"  # Ensure user is logged in as admin 
    When the user selects the "Admin" role
    And the user enters an invalid admin passcode
    Then the system displays an error message: "Invalid admin passcode"
    And denies access to the Admin Dashboard
