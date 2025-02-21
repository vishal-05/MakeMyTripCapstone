Feature: Validate user can book a flight

  Background:
    Given user open application
    Then verify user is on login page
    When user enters phone number "phone.number" and OTP
    Then verify user is on home page

  Scenario: verify user can book a flight
    When user clicks on flights
    Then verify user is on flight search page
    When user enters the details for booking flight "from.city", "to.city" and "departure.date"
    And user clicks on search button
    Then verify user is on flight listing page
    When user clicks on first flight
    And user clicks Book Now in the Saver category
    And print the price and user clicks on continue
    And user enters the traveller details "passenger.gender", "passenger.firstName" and "passenger.lastName"
    And print the finalized flight details