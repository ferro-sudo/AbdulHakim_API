@wip
Feature: Bank Account Validation



  Scenario: Positive
    Given a SampleRequest with a valid JWT token
    When sample request is posted to api
    Then Api returns ok

  Scenario: Negative
    Given a SampleRequest without a JWT token
    When sample request is posted to api
    Then Api returns "Authorization has been denied for this request.“ message.

  #Scenario: IBAN Validation
