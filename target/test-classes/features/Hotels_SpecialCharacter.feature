Feature: Hotel search special charaterss

  @hotelspecialcharacter
  Scenario: Input special characters while doing hotel search
  	Given User navigates to home page
  	When clicks on hotel icon
  	And enters special characters in city 
  	Then No results found message should be displayed