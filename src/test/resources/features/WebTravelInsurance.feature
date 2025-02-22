Feature: Validate user can view the insurance plan

  Background:
    Given user open application
   # Then verify user is on login page
  #  When user enters phone number "phone.number" and OTP
    Then verify user is on home page

  Scenario: verify user can view the insurance plan
    When user clicks on Travel Insurance
    Then verify user is on travel insurance page
    When user select the destination country "tourist.country"
    And user clicks on add to destination button
    Then verify user is on travel insurance page
    When user select the travel dates as start date "start.date" and end date "end.date"
    Then verify user is on travel insurance page
    When user select the traveller age "traveller.age"
    Then verify user is on travel insurance page
    When user clicks on view plans button
    Then verify user is on choose plan window
    And user prints all the plans that are displayed