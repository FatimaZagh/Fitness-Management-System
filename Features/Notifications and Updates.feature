Feature: Notifications and Updates
  As an instructor, I want to notify clients about important updates and announcements to keep them informed and engaged.

  Scenario: Notify Clients About Schedule Changes
    Given the instructor updates the program schedule
    When they save the changes
    Then the system notifies all enrolled clients about the updated schedule.

  Scenario: Announce a New Program
    Given the instructor has created a new program
    When they publish an announcement
    Then all potential clients see the announcement on their dashboards.

  Scenario: Notify Clients About Special Offers
    Given the instructor wants to promote a discount or special offer
    When they create a new announcement with the offer details
    Then all clients receive a notification about the special offer.

  Scenario: Send Reminder for Upcoming Sessions
    Given a group session is scheduled for a program
    When the session date is approaching
    Then the system automatically sends a reminder notification to all enrolled clients.

  Scenario: Handle Invalid Notification Content
    Given the instructor wants to send a notification
    When they provide invalid content, such as an empty message
    Then the system displays an error message
    And the notification is not sent.

  Scenario: Notify Clients About Program Completion
    Given the instructor marks a program as "Completed"
    When they confirm the update
    Then the system notifies all enrolled clients about the program completion
    And clients can access archived materials.

  Scenario: Re-engage Inactive Clients
    Given the instructor wants to re-engage past or inactive clients
    When they send a personalized notification encouraging them to enroll in new programs
    Then the system sends the notification to the specified clients.