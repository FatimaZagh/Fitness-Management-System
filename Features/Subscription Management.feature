Feature: Subscription Management
  Purpose: Handles subscription plans and related data.

  Scenario: Admin creates new subscription plans
    Given the admin is on the Subscription Management page
    When the admin selects "Create New Subscription Plan"
    And provides valid details (e.g., name, price, features)
    Then the system creates a new subscription plan
    And displays a success message: "Subscription plan created successfully"

  Scenario: Admin updates prices or features of existing subscription plans
    Given the admin is on the Subscription Management page
    And the "Gold Plan" subscription exists
    When the admin selects an existing subscription plan
    And updates the price or features
    Then the system updates the plan successfully
    And displays a success message: "Subscription plan updated successfully"

  Scenario: Admin views statistics of subscription plans
    Given the admin is on the Subscription Management page
    When the admin selects "View Subscription Statistics"
    Then the system displays statistics such as the most popular subscription plans
