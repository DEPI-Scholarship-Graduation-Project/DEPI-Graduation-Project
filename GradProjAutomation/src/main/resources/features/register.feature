Feature: Register Feature
  @HappyScenario
  Scenario Outline: Valid Register
    Given User opens Home page and clicks on register link
    When User selects "<gender>" and enters valid "<firstName>", "<lastName>", "<email>", "<password>", and "<confirmPassword>" and press on register button
    Then Registration Completion page opens successfully and success message "Your registration completed" appears

    Examples:
      | gender | firstName   | lastName | email | password | confirmPassword |
      | Male   | Mohamed     | Abdulaziz| mohamed123.aziz@test50.com | QaTest@123   | QaTest@123   |
      | FEMALE | Mariam      | Adel     | mariam.adill23@example50.com| QaTester@369 | QaTester@369 |
      | M      | Muhammad    | Emad     | muhammad.emad1233@email50.com| TestP@ssword123 | TestP@ssword123 |

  @Regression
  Scenario Outline: Register using a registered email
    Given User opens Home page and clicks on register link
    When User selects "<gender>" and enters valid "<firstName>", "<lastName>", "<password>", "<confirmPassword>" and registered "<email>" and press on register button
    Then The error message for registered email "The specified email already exists" appears

    Examples:
      | gender | firstName   | lastName | email | password | confirmPassword |
      | Male   | Mohamed     | Abdulaziz| mohamed123.aziz@test1.com | QaTest@123   | QaTest@123   |
      | FEMALE | Mariam      | Adel     | mariam.adill23@example.com| QaTester@369 | QaTester@369 |
      | M      | Muhammad    | Emad     | ironmedo100@gmail.com     | TestP@ssword123 | TestP@ssword123 |

  @Regression
  Scenario Outline: Register using an invalid email format
    Given User opens Home page and clicks on register link
    When User selects "<gender>" and enters valid "<firstName>", "<lastName>", "<password>", "<confirmPassword>" and invalid "<email>" format and press on register button
    Then The error message for "Wrong email" format appears

    Examples:
      | gender | firstName   | lastName | email | password | confirmPassword |
      | Male   | Mohamed     | Abdulaziz| mohamed123.aziz.com | QaTest@123   | QaTest@123   |
      | FEMALE | Mariam      | Adel     | mariam.adill23@example| QaTester@369 | QaTester@369 |

  @Regression
  Scenario Outline: Register using mismatched passwords
    Given User opens Home page and clicks on register link
    When User selects "<gender>" and enters valid "<firstName>", "<lastName>", "<email>", and mismatch "<password>" and "<confirmPassword>" and press on register button
    Then The error message for mismatching passwords "The password and confirmation password do not match." appears

    Examples:
      | gender | firstName   | lastName | email | password | confirmPassword |
      | Male   | Mohamed     | Abdulaziz| mohamed123.aziz@test30.com | QaTest@123   | QaTest@123456   |
      | FEMALE | Mariam      | Adel     | mariam.adill23@example30.com| QaTester@369 | Tester369      |

  @Regression
  Scenario Outline: Register using a short password
    Given User opens Home page and clicks on register link
    When User selects "<gender>" and enters valid "<firstName>", "<lastName>", "<email>", and short "<password>" and "<confirmPassword>" and press on register button
    Then The error message for short passwords "The password should have at least 6 characters." appears

    Examples:
      | gender | firstName   | lastName | email | password | confirmPassword |
      | Male   | Mohamed     | Abdulaziz| mohamed123.aziz@test30.com  | 123 | 123 |
      | FEMALE | Mariam      | Adel     | mariam.adill23@example30.com| 369 | 369 |

  @Regression
  Scenario Outline: Register without selecting the gender
    Given User opens Home page and clicks on register link
    When User doesn't select "<gender>" and enters valid "<firstName>", "<lastName>", "<email>", "<password>", and "<confirmPassword>" and press on register button
    Then The error message for missing gender "Gender is required." appears

    Examples:
      | gender | firstName   | lastName | email | password | confirmPassword |
      |        | Mohamed     | Abdulaziz| mohamed123.aziz@test5.com | QaTest@123   | QaTest@123   |
      |        | Mariam      | Adel     | mariam.adill23@example5.com| QaTester@369 | QaTester@369|

  @Regression
  Scenario Outline: Register with an empty first name
    Given User opens Home page and clicks on register link
    When User selects "<gender>", leave "<firstName>" empty and enters valid "<lastName>", "<email>", "<password>", and "<confirmPassword>" and press on register button
    Then The error message for missing first name "First name is required." appears

    Examples:
      | gender | firstName   | lastName | email | password | confirmPassword |
      | Male   |             | Abdulaziz| mohamed123.aziz@test30.com | QaTest@123   | QaTest@123   |
      | FEMALE |             | Adel     | mariam.adill23@example30.com| QaTester@369 | QaTester@369|

  @Regression
  Scenario Outline: Register with an empty last name
    Given User opens Home page and clicks on register link
    When User selects "<gender>" and enters valid "<firstName>", "<email>", "<password>", and "<confirmPassword>" and leave "<lastName>" empty and press on register button
    Then The error message for missing last name "Last name is required." appears

    Examples:
      | gender | firstName   | lastName | email | password | confirmPassword |
      | Male   | Mohamed     |          | mohamed123.aziz@test30.com | QaTest@123   | QaTest@123   |
      | FEMALE | Mariam      |          | mariam.adill23@example30.com| QaTester@369 | QaTester@369|