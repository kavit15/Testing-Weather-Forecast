Feature: Five day weather forecast is displayed when user enters city
Scenario Outline: Five day forecast is displayed when user enters city
    
    Given the user is on weather forecast page
    When user input city name as: Perth
    Then the forecast should have <Day>

    Examples:
     | Day |
     | Tue |
     | Wed |     
     | Thu |
     | Fri |
     | Sat |
