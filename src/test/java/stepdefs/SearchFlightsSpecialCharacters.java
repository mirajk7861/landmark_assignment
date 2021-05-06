package stepdefs;

import applicationPages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFlightsSpecialCharacters {
	private HomePage homePage;
	
	public SearchFlightsSpecialCharacters() {
		this.homePage = new HomePage();
	}
	@When("^enters special characters in from city$")
	public void enterSpecialCharacters() {
		this.homePage.enterSpecialCharactersInFromCity();
	}
	
	@Then("^no search results should be displayed$")
	public void noSearchResultPageShouldBeDisplayed() {
		this.homePage.verifyNoResultsMessageDisplayed();
	}
}
