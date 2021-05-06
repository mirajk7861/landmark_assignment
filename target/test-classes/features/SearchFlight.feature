Feature: Search flights 

  @searchflight
  Scenario: Search flights with any parameter
  	Given User navigates to home page
  	Then clicks on flight icon
  	And enters source and destination
  	And Clicks on Search button
  	Then Search results page should appear
 	