Feature: Check home page functionality

  Background: user is logged in
    Given user1 is on login page
    When user1 enters username and password
    And click on button
    Then user1 is navigated to the homepage

  Scenario: Check logout link
    When user1 clicks on welcome link
    Then logout link is displayed

  Scenario: Verify quick launch toolbar is present
    When user1 clicks on dashboard link
    Then quick launch toolbar is displayed
