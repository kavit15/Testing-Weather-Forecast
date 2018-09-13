Feature: Forecast summary with Most dominant (or current) condition,Most dominant (or current) wind speed and direction
Aggregate rainfall,Minimum and maximum temperatures should be displayed when clicked on a city.

 Scenario: when user enters city name forecast summary with all information needs to be displayed
  Given the user is on weather forecast page
   When user input city name as: Perth
   And user clicks on day1
  
  Then summary should be displayed as follows
   #| Hour| Description | Max_Temp | Min_Temp | Wind_Speed | Rainfall | Pressure
    | 1300 | Clouds | 14 | 12 | 2kph | 0mm | 1010mb |
    | 1600 | Clouds | 14 | 13 | 2kph | 0mm | 1009mb |
    | 1900 | Clouds | 11 | 10 | 1kph | 0mm | 1008mb |
    | 2200 | Clouds | 6  | 5  | 1kph | 0mm | 1008mb |