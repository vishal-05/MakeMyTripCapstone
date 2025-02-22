Feature: Validate user can filter bus details functionality

  Background:
    Given user open application
    #Then verify user is on login page
   #When user enters phone number "phone.number" and OTP
    Then verify user is on home page
    When user clicks on Buses
    Then verify user is on bus search page
    When user enters the details for booking bus "from.city", "to.city" and "departure.date"
    And user clicks on search buses button
    Then verify user is on bus listing page

  Scenario: verify user can filter bus details based on a specified bus name
    When user select the bus name "busFilter.name"
    And user print the name of buses that are displayed
    Then verify that only buses matching the specified bus name "busFilter.name" are displayed

  Scenario Outline: verify user can filter bus details based on a AC/Non Ac and Seater/sleeper
    When user select the bus filters "<ACOrNonAC>" and "<SeaterOrSleeper>"
    And user print the name and type of buses that are displayed
    Then verify that the buses matching the filters "<ACOrNonAC>" and "<SeaterOrSleeper>" are displayed

    Examples:
      |  ACOrNonAC  | SeaterOrSleeper |
      |     AC      |     Sleeper     |
      |    Non AC   |     Sleeper     |
      |     AC      |     Seater      |
      |    Non AC   |     Seater      |