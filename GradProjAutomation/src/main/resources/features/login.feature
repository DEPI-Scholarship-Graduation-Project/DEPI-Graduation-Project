Feature: Login Feature
  @HappyScenario
  Scenario: Valid Login
    Given User opens Home page and clicks on login link
    When User enters valid email "mohamed123.aziz@example.com" and password "QaTest@123" and press on login button
    Then Home page opens successfully and user is in logged in mode

  @Regression
  Scenario Outline: Login with invalid email format
    Given User opens Home page and clicks on login link
    When User enters invalid "<email>" format and valid "<password>" and press on login button
    Then The Error message "Please enter a valid email address." appears

    Examples:
      | email         | password   |
      | ahmed.ali.com | QaTest@123 |
      | ali@example   | QaTest@123 |
      | toms123       | QaTest@123 |

  @Regression
  Scenario Outline: Login with empty or non-registered email
    Given User opens Home page and clicks on login link
    When User enters empty or non-registered "<email>" and valid "<password>" and press on login button
    Then The Error message "No customer account found" appears

    Examples:
      | email                   | password   |
      | not@registered.email    | QaTest@123 |
      |                         | QaTest@123 |
      | emaildosntexit@test.com | QaTest@123 |

  @Regression
  Scenario Outline: Login with invalid password
    Given User opens Home page and clicks on login link
    When User enters valid "<email>" and invalid "<password>" and press on login button
    Then The Error message "The credentials provided are incorrect" appears

    Examples:
      | email                       | password |
      | mohamed123.aziz@example.com | 7@moksha!|
      | mohamed123.aziz@example.com | 123      |
      | mohamed123.aziz@example.com | supersecretsassword |