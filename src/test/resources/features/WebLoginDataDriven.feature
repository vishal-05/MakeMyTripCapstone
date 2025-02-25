Feature: Validate login and logout functionality

  Scenario Outline: verify user can login and logout
    Given user open application
    Then verify user is on login page
    When user enters phone number "<mobileNumber>" and OTP
    Then verify user is on home page
    Then verify user is logged in

    Examples:
      | mobileNumber |
      | 7094373317   |
      | 9584371449   |
      | 1234567890   |
      | 9980578176   |
