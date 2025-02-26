
Feature: Validate that the user can be created, then log in and log out

  Scenario: Login and Logout Api functionality
    Given user wants to call "/user" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "createUser.json" with type "CreateUser"
    When user performs post call
    Then verify status code is 200
    And store "username" from json file "createUser.json" to "username.value"


    Given user wants to call "/user/@username.value" end point
    When user performs get call
    Then verify status code is 200

    Given user wants to call "/user/login" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "loginUser.json" with type "LoginUser"
    When user performs get call
    Then verify status code is 200
    And verify response body has a field "message"

    Given user wants to call "/user/logout" end point
    When user performs get call
    Then verify status code is 200
    And verify response body has a field "message"
