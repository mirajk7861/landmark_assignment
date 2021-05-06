Feature: Applyfilters hotel search
Background:
Given User navigates to home page
  	When clicks on hotel icon
  	And Clicks on Hotel Search button
  	
  @hotel
  Scenario: Apply filters for property type 
  	Given User is in hotel search results page
  	When applies filter on property type
  	Then selected hotel type reuslts should be displayed
  	
  	
  	@userrating
  	Scenario: Apply filters for user rating
  	Given User is in hotel search results page
  	When applies filter on user ratings for good and excellent
  	Then selected user rated hotels should appear
  	
  	@hotel
  	Scenario: Apply filters for safety and hygiene
  	Given User is in hotel search results page
  	When selects safe and hygiene stay filter
  	Then only safety assured hotels should be displayed
  	