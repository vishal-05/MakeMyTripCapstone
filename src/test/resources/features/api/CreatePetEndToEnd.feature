@api
Feature: Validate User Can Create Pet

  Scenario: User performs end to end testing
    Given user wants to call "/pet" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "createPet.json" with type "CreatePet"
    When user performs post call
    Then verify status code is 200
    And store "id" from response to "pet.id"

    Given user wants to call "/pet/@pet.id" end point
    When user performs get call
    Then verify status code is 200

    Given user wants to call "/pet" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "updatePet.json" with type "CreatePet"
    And user performs put call
    Then verify status code is 200

    Given user wants to call "/pet/@pet.id" end point
    When user performs get call
    Then verify status code is 200

    Given user wants to call "/pet/@pet.id" end point
    And user performs delete call
    Then verify status code is 200

    Given user wants to call "/pet/@pet.id" end point
    When user performs get call
    Then verify status code is 404
    And verify response body has a field "message"

