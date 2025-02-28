@android
Feature: Validate user can zoom hotel image

  Background:
    Given user open application
    Then verify user is on login page
    When user enters phone number "phone.number" and OTP
    Then verify user is on home page
    When user clicks on hotels
    Then verify user is on hotel search page
#    When user enters the details for booking hotel "location.hotel", "checkIn.date" and "checkOut.date"
    And user clicks on hotel search button
    Then verify user is on hotel listing page
    When user clicks on first hotel

  Scenario: verify user can zoom hotel image
    Then verify user is on hotel details page
    When user clicks on a hotel image to view and zooms
    And user zoom out and navigate back to hotels details page
    Then verify user is on hotel details page
