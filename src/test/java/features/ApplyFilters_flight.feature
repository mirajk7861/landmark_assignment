Feature: Applyfilters flight search

Background:
Given User navigates to home page
  	Then clicks on flight icon
  	And enters source and destination
  	And Clicks on Search button
  	
  @airlinefilter
  Scenario: Apply filters for airlines
  	Given User is in search results page
  	When applies filter on airlines
  	Then selected airlines flights should be displayed
  	
  	@airlinefilter
  	Scenario: Apply filters for stops
  	Given User is in search results page
  	When applies filter on stops
  	Then selected stop flights should be displayed
  	
  	@airlinefilter
  	Scenario: Apply filters for Passenger and Class
  	Given User is in search results page
  	When selects two passengers
  	And selects business class 
  	And clicks on Done
  	And clicks on search
  	Then business class flights should be displayed
  	