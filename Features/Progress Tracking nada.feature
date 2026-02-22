
Feature: Progress Tracking

  # Scenario: Track Personal Fitness Milestones
  Scenario Outline: Track Personal Fitness Milestones
    Given the client has a current weight for progress tracking of "<initialWeight>" kg
    And the client has a height of "<height>" meters
    When the client updates their weight to "<newWeight>" kg
    And the client calculates their BMI for progress tracking
    Then the system tracks the weight as "<newWeight>" kg
    And the system calculates and tracks the BMI as "<expectedBMI>"

    Examples:
      | initialWeight | height | newWeight | expectedBMI |
      | 70            | 1.75  | 75        | 24.49       |
      | 80            | 1.80  | 78        | 24.07       |
# Scenario: Track Attendance
  Scenario Outline: Track Attendance
    Given the client is enrolled in program "<programName>"
    When the client attends the session on "<sessionDate>"
    Then the system records the attendance for "<programName>" on "<sessionDate>"

    Examples:
      | programName          | sessionDate  |
      | Weight Loss Program   | 2024-12-01   |
      | Strength Training     | 2024-12-02   |
      | Yoga for Beginners    | 2024-12-03   |

  # Scenario: View Achievements
  Scenario: View Achievements
    Given the client has completed the following programs:
      | programName          | completionDate |
      | Weight Loss Program  | 2024-12-01     |
      | Strength Training    | 2024-12-05     |
    When the client views their program achievements
    Then the system displays the following program achievements:
      | achievementTitle      | achievementDescription                      |
      | Weight Loss Champion   | Completed the Weight Loss Program           |
      | Strength Training Pro   | Completed the Strength Training Program     |
  # Scenario: View Badges for Completing Programs
  Scenario: View Badges
    Given the client has earned the following badges:
      | badgeTitle            | badgeDescription                          |
      | 5K Runner             | Completed a 5K run                       |
      | Consistent Attendee   | Attended 10 sessions in a program        |
    When the client views their badges
    Then the system displays the following badges:
      | badgeTitle            | badgeDescription                          |
      | 5K Runner             | Completed a 5K run                       |
      | Consistent Attendee   | Attended 10 sessions in a program  |

