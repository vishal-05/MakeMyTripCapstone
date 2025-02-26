@api
Feature: Validate Create User Endpoints

  Scenario: User performs end to end testing
    Given user wants to call "/user" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "createUser.json" with type "CreateUser"
    When user performs post call
    Then verify status code is 200
    And store "username" from json file "createUser.json" to "username.value"

    Given user wants to call "/user/@username.value" end point
    When user performs get call
    Then verify status code is 200

    Given user wants to call "/user/@username.value" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "updateUser.json" with type "CreateUser"
    And user performs put call
    Then verify status code is 200
    And store "username" from json file "updateUser.json" to "updatedUsername.value"

    Given user wants to call "/user/@updatedUsername.value" end point
    When user performs get call
    Then verify status code is 200

    Given user wants to call "/user/@updatedUsername.value" end point
    And user performs delete call
    Then verify status code is 200

    Given user wants to call "/user/@updatedUsername.value" end point
    When user performs get call
    Then verify status code is 404
    And verify response body has a field "message"

