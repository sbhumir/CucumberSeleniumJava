# Generally Cucumber Selenium is used for Web Testing. This RESTful API test is just a demo, no need to use Selenium for this test
Feature: HttpClient Post

  Scenario: Test HttpClient Post method
    Given user sends an http request
    Then user verifies the response
