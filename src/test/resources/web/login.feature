@Login @UI
Feature: Login

  @ExecuteLogout
  Scenario Outline: A user with valid account should be able to login
    Given The user is in the Login page
    When The user logs in with her "<User>" valid account
    Then The user login into the page successfully

    Examples:
      | User           |
      | user           |
      | user1          |