Feature: Search hotels 

  @hotel
  Scenario: Search hotel with any parameter
  	Given User navigates to home page
  	When clicks on hotel icon
  	And Clicks on Hotel Search button
  	Then hotel search results appear
  	
  	