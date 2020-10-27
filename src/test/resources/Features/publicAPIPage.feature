Feature: Test Login functionality

  Scenario: check login is successful with valid credentials
    Given API page is open
    And user is on API page
    When user clicks on get users
    And user clicks on span users link
    Then user is navigated to API results