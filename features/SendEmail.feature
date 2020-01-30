Feature: Email server

  Scenario: Send Email
    Given A User sends an "hello" message
    When The message is converted by the Adapter
    Then The Message server should contain the "hello" message in the queue