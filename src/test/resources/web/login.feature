@Login @UI
Feature: Login

  @ExecuteLogout
  Scenario Outline: A user with valid account should be able to login
    Given the user is in the Login page
    When the user logs in with her "<User>" valid account
    Then the user should login into the page successfully

    Examples:
      | User           |
      | user           |
      | user1          |