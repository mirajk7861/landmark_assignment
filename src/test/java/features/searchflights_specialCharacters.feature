Feature: Search flights by special characters

@FlightSpecialcharacter
Scenario:Search flights by special characters
  	Given User navigates to home page
  	When enters special characters in from city
  	Then no search results should be displayed