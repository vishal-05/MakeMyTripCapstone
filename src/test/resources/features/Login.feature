@web
Feature: Validate login and logout functionality

  Scenario: verify user can login and logout
    Given user open application
    Then verify user is on login page
    When user enters phone number "phone.number" and OTP
    Then verify user is on home page
    Then verify user is logged in




