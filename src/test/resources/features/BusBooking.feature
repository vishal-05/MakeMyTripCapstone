

Feature: Validate user can book a bus

  Background:
    Given user open application
    Then verify user is on login page
    When user enters phone number "phone.number" and OTP
    Then verify user is on home page

  Scenario: verify user can book a bus
    When user clicks on Buses
    Then verify user is on bus search page
    When user enters the details for booking bus "from.city", "to.city" and "departure.date"
    And user clicks on search buses button
    Then verify user is on bus listing page
    When user clicks on first bus
    And user clicks on the first available seat
    Then verify pickup and drop points are visible
    When user selects pickup and drop points
    Then verify review booking is visible and print finalized bus booking details