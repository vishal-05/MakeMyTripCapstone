Feature: Validate login logout functionality

  Scenario: verify user can login and logout
    Given user open application
    Then verify user is on login page
    When user enters phone number "phone.number" and OTP
    Then verify user is on home page
    Then verify user is logged in
    When user clicks on my profile
    And clicks logout option
    Then verify user is logged out



