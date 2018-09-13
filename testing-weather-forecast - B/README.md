# Testing weather forecast application
This project tests weather forecast application using selenium-java

This application covers testing of following features 

## Features
Enter city name, get 5 day weather forecast
 
 Select day, get 3 hourly forecast
 
 Select day again, hide 3 hourly forecast
 
 Daily forecast should summarise the 3 hour data:
 
   Most dominant (or current) condition
   Most dominant (or current) wind speed and direction
   Aggregate rainfall
   Minimum and maximum temperatures

## Techincal Overview

Automation test suite is built using Selenium,java and cucumber 

Following Feature files are created in Gherkin language and present in src/test/resources

* ThreeHourForecast - validates whether hourly forecast is displayed when day is selected

* ForecastSummary   - validates display of forecast summary

* FiveDayForecast   - validates whether fiveday weather forecast is displayed

* Errormsg          - validates whether error message is displayed when wrong city name is entered
 
WeatherRunner is present in location src/test/java

Step Definition(Weathersteps) is present in location src/test/java


## Pre-requisites

Java is installed in the machine
Chrome driver is installed in the machine


## Running Tests 

* Run the Weather Application 
* Run WeatherRunner.java in IDE


## Note 

* ChromeDriver already bundled with this project under Directory :drivers
