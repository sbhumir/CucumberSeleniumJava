Feature: Check login functionality

	@smoke
  Scenario: 
    Given Hooks is on login page
    When Hooks enters valid username and password
    And click on login button
    Then Hooks is navigated to the home page

  Scenario: 
    Given Hooks is on login page
    When Hooks enters valid username and password
    And click on login button
    Then Hooks is navigated to the home page
