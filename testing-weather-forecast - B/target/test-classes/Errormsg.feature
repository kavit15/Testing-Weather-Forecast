Feature: Error message should be displayed for invalid input in city name
Scenario: Displays error message when invalid input is given for city name
    Given the user is on weather forecast page
  	When user input city name as: January
    Then error message is displayed