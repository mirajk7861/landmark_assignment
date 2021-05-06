package stepdefs;

import applicationPages.HomePage;
import applicationPages.HotelSearchResultsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchHotelsResults {
private HomePage homePage;
	private HotelSearchResultsPage hotelSearchResultsPage;
	public SearchHotelsResults() {
		this.homePage = new HomePage();
		this.hotelSearchResultsPage= new HotelSearchResultsPage();
	}
	@When("^clicks on hotel icon$")
	public void clickOnHotelIcon() {
		this.homePage.clickOnHotelIcon();
		
	}
	@When("^selects rooms and guests$")
	public void selectsRoomsAndGuests() {
		this.homePage.selectRoomsAndGuests();
	}
	@When("^Clicks on Hotel Search button$")
	public void clickSearch() {
		this.homePage.clickOnHotelSearch();
	}
	
	@Then("^hotel search results appear$")
	public void verifyHotelSearchPage() {
		this.hotelSearchResultsPage.verifyHotelSearchPageDisplayed();
	}
	
}
