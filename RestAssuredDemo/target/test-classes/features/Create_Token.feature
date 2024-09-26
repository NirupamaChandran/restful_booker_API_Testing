Feature: Validate create token

  Scenario Outline: Verify user can create token scenario
    When user wants to call "/auth" end point
    And set header "Content-Type" to "application/json"
    And set request body from the file "create_token.json" with username "<username>" and password "<password>"
    When user performs post call
    Then verify status code is 200
    And verify response message is "Bad credentials"

    Examples:
      |username|password|
      |admin   |admin123|
      |Admin   |admin|
      |admin1  |admin1|

