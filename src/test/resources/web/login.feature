@Login @UI
Feature: Login
  @ExecuteLogout
  Scenario Outline: A user with valid account should be able to login to automation website
    Given I navigate to Automation page
    When I login to Automation page with a valid "<User Site>" account
    Then I should login to Automation page successfully

    Examples:
      | User Site      |
      | user           |
      | user1          |