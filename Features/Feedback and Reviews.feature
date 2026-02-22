Feature: Feedback and Reviews

  Scenario: Rate a Completed Program
    Given the client has completed the program "Weight Loss Program"
    When the client rates the program with a score of 4
    Then the system records the rating for "Weight Loss Program" as 4

  Scenario: Review a Completed Program
    Given the client has completed the program "Strength Training"
    When the client submits a review "Great program, helped me build strength!"
    Then the system records the review for "Strength Training"

  Scenario: Submit Improvement Suggestions
    Given the client has completed the program "Yoga for Beginners"
    When the client submits an improvement suggestion "Add more advanced poses."
    Then the system records the suggestion for "Yoga for Beginners"