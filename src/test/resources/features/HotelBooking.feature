

Feature: Validate user can book a hotel

  Background:
    Given user open application
    Then verify user is on login page
    When user enters phone number "phone.number" and OTP
    Then verify user is on home page

  Scenario: verify user can book a hotel
    When user clicks on hotels
    Then verify user is on hotel search page
    When user enters the details for booking hotel "location.hotel", "checkIn.date" and "checkOut.date"
    And user clicks on hotel search button
    Then verify user is on hotel listing page
    When user clicks on first hotel
    And print the price per night and select room
    And print the finalized hotel details