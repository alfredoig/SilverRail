Feature: Technical Ability

  Scenario: Question1

    Given a response from the webservice
    When the response message is verified
    Then it should have Success status and code 0
    Then it should have code 0

    Given post code AB107AP
    When the web service response is obtained
    Then the response should have the post code AB107AP
    Then it should also have its coordinates

    Given post code AB107AP
    When the web service response is obtained
    Then the response should have all train stations within 50 miles

    Given post code AB107AP
    When the web service response is obtained
    Then stations CRS, distance and coordinates should be obtained

    Given post code AB107AP
    When the web service response is obtained
    Then Performance Information: TimeStamp, PreprocessingWait, PreprocessingWait, ProcessingTime, ComputerName and InstanceId should be obtained

    Given post code AB107AP
    When the web service response is obtained
    Then station ABC should not be in the response

    Given post code AB107AP
    When the web service response is obtained
    Then the distance should be in miles with 2 decimals