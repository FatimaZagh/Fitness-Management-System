Feature: Program Exploration and Enrollment

  # Scenario: Browse programs by difficulty level
  Scenario Outline: Browse Programs by Difficulty Level
    Given the client is on the program enrollment page
    When the client browses programs by difficulty level "<difficultyLevel>"
    Then the system displays programs with difficulty level "<difficultyLevel>"

    Examples:
      | difficultyLevel |
      | Beginner        |
      | Intermediate    |
      | Advanced        |

  # Scenario: Browse programs by focus area
  Scenario Outline: Browse Programs by Focus Area
    Given the client is on the program enrollment page
    When the client browses programs by focus area "<focusArea>"
    Then the system displays programs with focus area "<focusArea>"

    Examples:
      | focusArea         |
      | Weight Loss       |
      | Muscle Building    |
      | Flexibility       |

  # Scenario: Enroll in a program
  Scenario Outline: Enroll in a Program
    Given the client is on the program enrollment page
    When the client enrolls in program "<programName>"
    Then the system displays the schedule for program "<programName>"

    Examples:
      | programName          |
      | Weight Loss Program   |
      | Strength Training     |
      | Yoga for Beginners    |
