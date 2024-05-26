Feature: Validation of Places in the API

  @AddPlace
  Scenario: Verify Add a place in the API
   Given Add Place Payload
    When User calls "AddPlaceAPI" for adding place using "POST" Http request
    Then The API response should be success with status code 200
    And The "status" of response body is "OK"
    And The "scope" of response body is "APP"
      
      
     @AddMultiplePlace 
     Scenario Outline: Verify Add multiple places in the API 
      Given Add Multiple Places Payload "<Name>" "<Address>" "<MobileNo>" "<Website>" "<Language>"
      When User calls "AddPlaceAPI" for adding place using "POST" Http request
      Then The API response should be success with status code 200
      And The "status" of response body is "OK"
      And The "scope" of response body is "APP"
      When User calls "GetPlaceAPI" for getting details using "Get" Http request
      Then The API response should be success with status code 200
      Then Verify the placeid gernated maps to the "<Name>" 
        
      Examples: 
      |Name |Address        |MobileNo  |Website        |Language |
      |Rinku|SR Nagar Bankok|1234567892|www.youtube.com|Hindi    |
      |Sonu |VP Court Cryprn|5698785989|www.qspider.com|English  |
      |Rakesh|XER Phase1 Git|9875689669|www.google.com |English  |
  
  
    @DeletePlace
    Scenario: Verify Delete a place in the API
    Given Delete Place Payload
    When User calls "DeletePlaceAPI" for deleting place using "POST" Http request
    Then The API response should be success with status code 200
    And The "status" of response body is "OK"

    
    
