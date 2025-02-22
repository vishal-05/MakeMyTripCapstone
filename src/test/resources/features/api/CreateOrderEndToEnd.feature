
Feature: Validate User Can Create Order

  Scenario: User performs end to end testing
    Given user wants to call "/store/inventory" end point
    When user performs get call
    Then verify status code is 200

    Given user wants to call "/store/order" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "createOrder.json" with type "CreateOrder"
    When user performs post call
    Then verify status code is 200
    And verify response body has a field is "token"

    Given user wants to call "/store/order/5" end point
    When user performs get call
    Then verify status code is 200

    Given user wants to call "/store/order/5" end point
    When user performs delete call
    Then verify status code is 200

    Given user wants to call "/store/order/5" end point
    When user performs get call
    Then verify status code is 404
