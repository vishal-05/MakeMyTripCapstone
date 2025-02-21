
Feature: Validate user can book a cab

  Background:
    Given user open application
    Then verify user is on login page
    When user enters phone number "phone.number" and OTP
    Then verify user is on home page

  Scenario: verify user can book a cab
    When user clicks on airport cabs
    Then verify user is on cab search page
    When user enters the details for booking cab "from.location", "to.location" and "trip.date"
    And user clicks on search cab button
    Then verify user is on cab listing page
    When user clicks on first cab
    And user enters traveller details "passenger.gender"
    And selects full pay option and clicks pay now
    Then verify traveller name is correct
    And print total fare