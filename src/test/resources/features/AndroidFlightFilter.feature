

Feature: validate flight name filter functionality

  Background:
    Given user open application
    Then verify user is on login page
    When user enters phone number "phone.number" and OTP
    Then verify user is on home page
    When user clicks on flights
    Then verify user is on flight search page
    When user enters the details for booking flight "from.city", "to.city" and "departure.date"
    And user clicks on search button
    Then verify user is on flight listing page

  Scenario: verify user can apply flight name filter
    When user selects on filter option "flight.filter.option"
    Then verify only "flight.filter.option" flights are displayed on the page


  Scenario: verify user can sort based on time
    When user selects on sort option "flight.sort.option"
    Then verify flights are sorted by "flight.sort.option"
