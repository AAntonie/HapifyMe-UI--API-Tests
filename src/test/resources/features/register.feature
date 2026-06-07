
Feature: User Registration

  Scenario: Create a new account successfully
    Given I am on the registration page
    When I enter first name "Ana"
    And I enter last name "Test"
    And I enter email "ana"
    And I enter confirm email
    And I enter password "Test@123"
    And I enter confirm password "Test@123"
    And I click on register button
    Then I should see registration success message

  Scenario: Invalid registration - password validation
    Given I am on the registration page

    When I try to register with:
      | password  | confirmPassword | message                                                                                                                        |
      | Test@12   | Test@12         | Your password must be at least 8 characters long and include uppercase letters, lowercase letters, numbers, and special characters. |
      | test@123  | test@123        | Your password must be at least 8 characters long and include uppercase letters, lowercase letters, numbers, and special characters. |
      | TEST@123  | TEST@123        | Your password must be at least 8 characters long and include uppercase letters, lowercase letters, numbers, and special characters. |
      | Test@Test | Test@Test       | Your password must be at least 8 characters long and include uppercase letters, lowercase letters, numbers, and special characters. |
      | Test1234  | Test1234        | Your password must be at least 8 characters long and include uppercase letters, lowercase letters, numbers, and special characters. |