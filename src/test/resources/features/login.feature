Feature: Login functionality

  Background:
    Given user is on login page

  Scenario: Successful login
    When user logs in with valid credentials
    Then user should be redirected to feed page

  Scenario: Login with empty email field keeps user on login page
    When user leaves email field empty
    And user enters password "Test@123"
    And user clicks login button
    Then user remains on login page

  Scenario: Login with empty password field keeps user on login page
    When user enters email "ana@mail.com"
    And user leaves password field empty
    And user clicks login button
    Then user remains on login page

  Scenario Outline: Unsuccessful login attempts
    When user logs in with username "<username>" and password "<password>"
    Then login should fail and error message is displayed

    Examples:
      | username        | password  |
      | wrong@mail.com  | Test@123  |
      | ana@mail.com    | wrongPass |
      | wrong@mail.com  | wrongPass |