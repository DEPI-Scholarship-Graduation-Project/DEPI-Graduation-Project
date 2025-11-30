Feature: Forget Password Feature
  @HappyScenario
  Scenario: Using Registered Email
    Given User opens Home page and clicks on login link and clicks on forget password link
    When User enters registered email "mohamed123.aziz@example.com" and press on recover button
    Then The message message "Email with instructions has been sent to you." appears

  @NegativeScenario
  Scenario: Using Non Registered Email
    Given User opens Home page and clicks on login link and clicks on forget password link
    When User enters non-registered email "not.registered@email.com" and press on recover button
    Then The message message "Email not found." appears