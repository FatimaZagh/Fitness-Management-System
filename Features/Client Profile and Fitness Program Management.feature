Feature: Client Profile and Fitness Program Management

  # Scenario 1: Update Client Profile
  Scenario Outline: Update client profile
    Given the client is on the profile management page
    When the client enters their details with name "<name>", age "<age>", fitness goal "<fitnessGoal>", and dietary preference "<dietaryPreference>"
    And the client clicks on the save button
    Then the system shows a message "Profile updated successfully!"

    Examples:
      | name        | age | fitnessGoal         | dietaryPreference |
      | John Doe    | 30  | Weight Loss         | Vegetarian       |
      | Jane Smith  | 25  | Muscle Gain         | Gluten-Free      |
      | Alice Brown | 28  | Improved Endurance   | Vegan            |
      | Bob White   | 35  | General Fitness      | Keto             |

  # Scenario 2: Display Client Profile
  Scenario: Display client profile
    Given the client is logged in
    When the client views their profile
    Then the system displays the following details:
      | name        | age | fitnessGoal         | dietaryPreference |
      | John Doe    | 30  | Weight Loss         | Vegetarian       |

  # Scenario 3: Dietary preferences or restrictions summary
  Scenario Outline: Client updates dietary preferences or restrictions
    Given the client is on the profile management page
    When the client adds dietary preferences or restrictions "<dietaryPreference>"
    And the client clicks on the save button
    Then the system shows a message "Dietary preferences updated successfully!"

    Examples:
      | dietaryPreference         |
      | Vegan                     |
      | Dairy-Free                |
      | Gluten-Free               |
      | Nut-Free                  |
      | Nut-Free and Gluten-Free  |
      | Paleo                     |
      | Low-Carb                  |

  # Scenario 4: View Dietary Preferences Summary
  Scenario: View dietary preferences summary
    Given the client is logged
    When the client views their dietary preferences
    Then the system displays the following dietary preferences:
      | dietaryPreference         |
      | Vegetarian                |
      | Gluten-Free               |

  # Scenario 5: Create New Client Profile
  Scenario: Create a new client profile
    Given the client is on the profile creation page
    When the client enters their details with name "Emily Johnson", age "27", fitness goal "Weight Maintenance", and dietary preference "Paleo"
    And the client clicks on the create button
    Then the system shows a message "Profile created successfully!"