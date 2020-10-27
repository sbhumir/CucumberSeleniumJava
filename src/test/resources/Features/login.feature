#Author: Sirisha Bhumireddy
#Description: Cucumber Java SmokeTest
@SmokeScenario
Feature: feature to test login

  @SmokeTest
  Scenario Outline: Check login is successful with valid credentials
    Given chrome is open
    And user is on login page
    When user enters <username> and <password>
    And user clicks on login
    Then user is navigated to home page

    Examples: 
      | username | password |
      | user1    |    12345 |
      | user2    |    12345 |
