Feature: Program Monitoring
  Purpose: Focuses on monitoring program-related statistics and reports.

  Scenario: Admin views enrollment statistics for all fitness programs
    Given the admin is on the Program Monitoring page
    When the admin selects "View Enrollment Statistics"
    Then the system displays statistics for all programs

  Scenario: Admin generates reports on revenue from paid programs
    Given the admin is on the Program Monitoring page
    When the admin selects "Generate Revenue Report"
    Then the system generates and displays a detailed revenue report

  Scenario: Admin generates reports on attendance across group sessions
    Given the admin is on the Program Monitoring page
    When the admin selects "Generate Attendance Report"
    Then the system generates and displays an attendance report

  Scenario: Admin generates reports on client progress
    Given the admin is on the Program Monitoring page
    When the admin selects "Generate Client Progress Report"
    Then the system generates and displays a detailed client progress report

  Scenario: Admin tracks active and completed programs
    Given the admin is on the Program Monitoring page
    When the admin selects "Track Active and Completed Programs"
    Then the system displays a list of active and completed programs
