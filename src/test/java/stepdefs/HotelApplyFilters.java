package stepdefs;

import applicationPages.HotelSearchResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelApplyFilters {

	private HotelSearchResultsPage hotelpage;

	public HotelApplyFilters() {
		this.hotelpage = new HotelSearchResultsPage();
	}

	@Given("^User is in hotel search results page$")
	public void userIsInHotelSearchResultsPage() {
		this.hotelpage.verifyHotelSearchPageDisplayed();
	}

	@When("^applies filter on property type$")
	public void applyFilterOnPropertyType() {
		this.hotelpage.applyFilterOnPropertyType();
	}

	@Then("^selected hotel type reuslts should be displayed$")
	public void verifyPropertyTypeFilterResults() {
		this.hotelpage.verifyPropertyTypeFilterResults();
	}

	@When("^applies filter on user ratings for good and excellent$")
	public void applyFilterOnUserRatings() {
		this.hotelpage.applyFilterForUserRatings();
	}

	@Then("^selected user rated hotels should appear$")
	public void selectedRatedHotelsAppear() {
		this.hotelpage.verifyUserRatedHotelsDisplayed();
	}

	@When("^selects safe and hygiene stay filter$")
	public void applySafetyFilter() {
		this.hotelpage.applySafetyFilter();
	}

	@Then("^only safety assured hotels should be displayed$")
	public void verifySafetyFilter() {
		this.hotelpage.verifySafetyAssuredHotelsDisplayed();
	}
}
