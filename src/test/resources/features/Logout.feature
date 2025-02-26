
Feature: Validate login and logout functionality

  Background:
    Given user open application
    Then verify user is on login page
    When user enters phone number "phone.number" and OTP
    Then verify user is on home page

  Scenario: verify user can logout
    Then verify user is logged in
    When user clicks on my profile
    And clicks logout option
    Then verify user is logged out



