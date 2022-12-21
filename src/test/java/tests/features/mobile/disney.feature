Feature: Disney workflow
  In order to consume Disney app content
  As a Disney app user
  User can navigate through different sections in the app

  Background:
    Given User is in Dashboard screen

  @DisneyNavigation
  Scenario: User can interact in map screen and its category list
    Given User is in map screen
    When User clicks category list button
    Then Categories, including hotels option should be displayed

  @DisneyNavigation
  Scenario: User can interact in privacy & legal option
    Given User is in more options screen
    When User selects privacy & legal option
    Then Privacy & Legal options should be displayed

  @DisneyNavigation
  Scenario: User can interact in add plans option
    Given User is in add plans screen
    When User selects dining availability option
    Then The party size option should be displayed
