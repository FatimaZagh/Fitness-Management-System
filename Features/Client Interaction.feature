Feature: Client Interaction
  As an instructor, I want to communicate with clients effectively to support their progress and address their questions.

  Scenario: Send a Message to Clients
    Given the instructor is logged into their account
    And clients are enrolled in their program
    When the instructor sends a message through the program's discussion forum
    Then the clients receive the message in their accounts.

  Scenario: Respond to a Client's Query
    Given the instructor has received a query from a client
    When the instructor replies to the query
    Then the client is notified of the response.

  Scenario: Provide Feedback on Client Progress
    Given the instructor is monitoring a client's performance
    When they add progress feedback or recommendations
    Then the client can view the feedback in their account.

  Scenario: Notify Clients About Program Updates
    Given the instructor updates a program's schedule or content
    When they confirm the update
    Then the system notifies all enrolled clients about the changes.

  Scenario: Handle Client Messages with Invalid Inputs
    Given the instructor wants to send a message to clients
    When they provide invalid input, such as empty or overly long messages
    Then the system displays an error message for ClientInteraction
    And the message is not sent.

  Scenario: Start a New Discussion Topic
    Given the instructor wants to engage clients in a program
    When they create a discussion topic in the forum
    Then enrolled clients can view and respond to the topic.