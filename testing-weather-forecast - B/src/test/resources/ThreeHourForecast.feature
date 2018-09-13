Feature: Three Hourly forecast is displayed when user clicks on a day

Scenario: User should get three hourly forecast when he clicks on a day
    Given the user is on weather forecast page
    When user clicks on day1
    Then get three hourly forecast
    
 Scenario: If the user clicks on day again the hourly forecast should be hidden
    Given the user is on weather forecast page
    When user clicks on day1 again
    Then three hourly forecast should be hidden
   
 Scenario: A user should be able to see three hourly forecast for next day
    Given the user is on weather forecast page
    When user clicks on next day
    Then next day hourly forecast displayed