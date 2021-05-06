package stepdefs;

import applicationPages.FlightSearchResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightSearchResultsApplyFilters {
	private FlightSearchResultsPage searchResultsPage;
	public FlightSearchResultsApplyFilters() {
		this.searchResultsPage = new FlightSearchResultsPage();
	}

	@Given("^User is in search results page$")
	public void userIsInserchresultsPage() {
		this.searchResultsPage.validateFlightSearchresultspageDisplayed();
		
	}
	@When("^applies filter on airlines$")
	public void applyFilterForStops() {
		this.searchResultsPage.applyFilterForAirlines();
	}

	@Then("^selected airlines flights should be displayed$")
	public void verifyOnlySelctedAIrlinesFlightsAreDisplayed() {
		this.searchResultsPage.verifyOnlySelctedAirlinesFligtsAreDisplayed();
	}
	
	@Then("^applies filter on stops$")
	public void appliesFilterOnStops() {
		this.searchResultsPage.applyFilterOnStops();
	}
	
	@Then("^selected stop flights should be displayed$")
	public void verifyStopsDisplayedInResults() {
		this.searchResultsPage.verifyStopsDisplayed();
	}
	
	@When("^selects two passengers$")
	public void selectsTwoPassengers() {
		this.searchResultsPage.selectTwoPassengers();
	}
	
	@When("^selects business class$")
	public void selectsBusinessClass() {
		this.searchResultsPage.selectBusinessClass();
	}
	
	@When("^clicks on Done$")
	public void clickOnDone() {
		this.searchResultsPage.clickDone();
	}
	
	@When("^clicks on search$")
	public void clickOnSearch() {
		this.searchResultsPage.clickOnSearch();
	}
	
	@Then("^business class flights should be displayed$")
	public void verifyBusinessClassFlightsDisplayed() {
		this.searchResultsPage.verifyBusinessClassFLightsDisplayed();
	}
}
