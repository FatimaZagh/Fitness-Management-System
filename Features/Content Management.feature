Feature: Content Management
  Purpose: Manages approval/rejection of wellness content and user feedback.

  Scenario: Admin approves wellness content shared by instructors
    Given the admin is on the Content Management page
    When the admin reviews submitted wellness content
    And approves a content item
    Then the system updates the status to "Approved"
    And the content becomes visible to clients

  Scenario: Admin rejects wellness content that doesn’t meet standards
    Given the admin is on the Content Management page
    When the admin reviews submitted wellness content
    And rejects a content item
    Then the system updates the status to "Rejected"
    And the content is not displayed to clients

  Scenario: Admin reviews and approves articles submitted by external contributors
    Given the admin is on the Content Management page
    When the admin reviews external submissions
    And approves an article
    Then the system updates the status to "Approved"

  Scenario: Admin handles user feedback and complaints by responding to messages
    Given the admin is on the Content Management page
    When the admin views user feedback and complaints
    And responds to a message
    Then the system records the admin's response
    And notifies the user about the reply
