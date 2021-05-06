package stepdefs;

import java.io.IOException;

import javax.naming.directory.SearchResult;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.flightsearch.libraries.SuperTestNG;

import applicationPages.FlightSearchResultsPage;
import applicationPages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SearchFlights extends SuperTestNG {
	private HomePage homePage;
	private FlightSearchResultsPage searchResultsPage;

	public SearchFlights() {
		this.homePage = new HomePage();
		this.searchResultsPage = new FlightSearchResultsPage();
	}

	@Given("^User navigates to home page$")
	public void userNavigatesToHomePage() throws InvalidFormatException, IOException, ClassNotFoundException {

		try {
			this.homePage.goToHomePage();

		} catch (Exception e) {
			Assert.fail(e.getMessage());

		}
	}
	
	@Then("^clicks on flight icon$")
	public void clicksonFlightIcon() {
		this.homePage.clickOnFlightIcon();
	}

	@Then("^enters source and destination$")
	public void entersSourceAndDestination() {
		this.homePage.enterSourceAndDestination();
	}
	
	@Then("^Clicks on Search button$")
	public void clicksOnSearchButton() {
		this.homePage.clickOnSearchButton();
	}
	
	@Then("^Search results page should appear$")
	public void searchresultPageShouldAppear() {
		this.searchResultsPage.verifyIfSearchResultsAreDisplayed();
	}

}
