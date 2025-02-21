Feature: Validate user can convert the currency

  Background:
    Given user open application
    Then verify user is on login page
    When user enters phone number "phone.number" and OTP
    Then verify user is on home page

  Scenario Outline: verify user can convert the currency
    When user clicks on Forex Card & Currency
    Then verify user is on currency page
    When user clicks on select currency to proceed tab
    Then verify user is on select currency or country page
    When user select the country "<countryName>"
    And user enter the amount "<AmountToConvert>"
    And user get the amount in rupees
    And push the "<countryName>", amount to convert "<AmountToConvert>" and the amount in rupees in the excel sheet

    Examples:
    | countryName | AmountToConvert |
    |  Singapore  | 2000            |
    |  USA        | 10000           |
    |  Germany    | 50000           |