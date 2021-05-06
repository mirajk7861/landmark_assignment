package stepdefs;

import applicationPages.HomePage;
import applicationPages.HotelSearchResultsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SearchHotelsSpecialCharacters {

	private HomePage homePage;
	public SearchHotelsSpecialCharacters() {
	this.homePage = new HomePage();
	
}
	
	@When("^enters special characters in city$")
	public void enterSpecialCharacters() {
		this.homePage.enterSpecialCharactersForCityHOtel();
		
	}
	
	@Then("^No results found message should be displayed$")
	public void noResultsFoundMessageDisplayed() {
		this.homePage.verifyCantFindDestinationMessage();
	}
}
