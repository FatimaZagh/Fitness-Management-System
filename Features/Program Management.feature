Feature: Program Management
  As an instructor, I want to manage fitness programs so I can create, update, and maintain them effectively.

  Scenario: Create a New Program
    Given the instructor is logged into their account
    When they navigate to "Program Management" and click "Create New Program"
    And they provide all required details (title, duration, difficulty, goals, media, price)
    Then the system saves the program
    And it becomes available for clients to enroll.

  Scenario: Create a Program with Invalid Details
    Given the instructor is logged into their account
    When they provide invalid or incomplete details
    Then the system displays error messages
    And the program is not saved.

  Scenario: Update an Existing Program
    Given the instructor has existing programs
    When they modify program details (e.g., goals or price)
    Then the system updates the program
    And notifies enrolled clients.

  Scenario: Delete a Program
    Given there are no active clients in a program
    When the instructor deletes the program
    Then the system removes it from the platform.

  Scenario: Add Media to a Program
    Given the instructor wants to enhance a program
    When they upload valid media files
    Then the system adds the media
    And enrolled clients can access it.

  Scenario: Schedule Group Sessions
    Given the instructor wants to set a group session
    When they specify valid date, time, and location
    Then the system updates the schedule
    And notifies enrolled clients.

  Scenario: Handle Invalid Schedule Details
    Given the instructor provides a past date or conflicting time
    When they try to save the schedule
    Then the system displays an error
    And the schedule is not saved.

  Scenario: View Enrollment Metrics
    Given the instructor wants to track program performance
    When they open the dashboard
    Then the system shows key metrics like enrollments and completion rates.