Feature: ESPN workflow
  In order to consume ESPN content
  As a valid user
  The sign up process must be successfully, then is possible to interact through the page

  @EspnNavigation
  Scenario Outline: As a valid user, it can interact in ESPN home page and watch page
    Given User opens ESPN page
    When User is successful signed up "<name>" "<lastname>" "<password>"
    And  User goes to watch page
    Then Watch page must be displayed
    And User returns to home page, and should still connected "<name>"
    And User logs out from session

    Examples:
      | name      | lastname       | password       |
      | test-name | test-last-name | test-TO-delete |