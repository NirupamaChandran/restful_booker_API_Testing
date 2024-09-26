Feature: Validate create booking end point

  Scenario: Verify user can create booking
    Given user wants to call "/booking" end point
    And set header "Content-Type" to "application/json"
    And set request body from the file "create_booking.json"
    When user performs post call
    Then verify status code is 200

    Scenario: Verify user can get booking
      Given user wants to call "/booking" end point
      When user performs get call
      Then verify status code is 200
      And verify booking id is not empty


    Scenario: Verify user can update existing booking
      Given user wants to call "/booking" end point
      And set header "Content-Type" to "application/json"
      And set request body from the file "create_booking.json"
      When user performs post call
      Then verify status code is 200
      And verify booking id is not empty
      And stores created booking id into "booking.id"
      When user wants to call "/auth" end point
      When set header "Content-Type" to "application/json"
      And set request body from the file "create_token.json"
      When user performs post call
      Then verify status code is 200
      And store token value to "api.token"
      When user wants to call "/booking/@id" end point
      When set header "Content-Type" to "application/json"
      And set header "Cookie" to "token=@token"
      And set request body from the file "update_booking.json"
      And user performs put call
      Then verify status code is 200


  Scenario: Verify user can update existing booking using random
    Given user wants to call "/booking" end point
    And set header "Content-Type" to "application/json"
    And set request body from the file "create_booking.json"
    When user performs post call
    Then verify status code is 200
    And verify booking id is not empty
    And stores created booking id into "booking.id"

    When user wants to call "/auth" end point
    When set header "Content-Type" to "application/json"
    And set request body from the file "create_token.json"
    When user performs post call
    Then verify status code is 200
    And store token value to "api.token"

    When user wants to call "/booking/@id" end point
    When set header "Content-Type" to "application/json"
    And set header "Cookie" to "token=@token"
    And set request body from the file "create_booking.json" with random price
    And user performs put call
    Then verify status code is 200
