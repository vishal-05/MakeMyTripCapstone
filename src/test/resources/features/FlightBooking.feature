Feature: Validate user can book a flight

  Background:
    Given user open application
    Then verify user is on login page
    When user enters phone number and OTP
    Then verify user is on home page

  Scenario: verify user can book a flight
    When user click on flights
    Then verify user is on flight search page
    When user enters the details for booking flight "from.city", "to.city" and "departure.date"
    And user click on search button