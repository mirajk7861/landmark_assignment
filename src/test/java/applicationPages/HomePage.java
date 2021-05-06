package applicationPages;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.flightsearch.commonFunctions.Login;
import com.flightsearch.libraries.Generic;
import com.flightsearch.libraries.SuperTestNG;

public class HomePage extends SuperTestNG {
	
	public void goToHomePage() {
		Login.login(environment);

	}

	public void clickOnFlightIcon() {
		Generic.waitUntilElementIsClickable("flighticon",30);
	}

	public void enterSourceAndDestination() {
		try {
			Generic.waitForObject("frombutton", 10);
			Generic.findObject("frombutton").click();
			Thread.sleep(1000);
			Generic.findObject("frominput").sendKeys("DELHI");
			Thread.sleep(3000);
			Generic.findObject("firstoption").click();
			Generic.waitForObject("tobutton", 10);
			Generic.findObject("tobutton").click();
			Generic.findObject("toinput").sendKeys("BENGALURU");
			Thread.sleep(4000);
			Generic.findObject("firstoption").click();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void clickOnSearchButton() {
		Generic.hover("frombutton");
		Generic.waitUntilElementIsClickable("searchbutton", 20);
		
	}

	public void enterSpecialCharactersInFromCity() {
		try {
			Thread.sleep(7000);
			Generic.waitForObject("frombutton", 10);
			Generic.waitUntilElementIsClickable("frombutton", 20);
			//Generic.findObject("frombutton").click();
			Generic.performAction("frominput", "@#");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void verifyNoResultsMessageDisplayed() {
		try {
			Generic.waitForObject("nodatatext", 20);
			if (Generic.isElementdisplayed("nodatatext")) {
				String nodataText = Generic.findObject("nodatatext").getText();
				Assert.assertTrue(nodataText.contains("No Data Found"));
			} else {
				Assert.fail("No data found message not displayed");
			}
		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}
	}

	public void clickOnHotelSearch() {
		//Generic.findObject("hotelsearchbutton").click();
		Generic.waitUntilElementIsClickable("hotelsearchbutton",20);
	}

	public void selectRoomsAndGuests() {
		Generic.waitUntilElementIsClickable("inputguestsdropdown", 50);
		Generic.findObject("applyhotelsearch").click();
	}

	public void clickOnHotelIcon() {
		Generic.waitUntilElementIsClickable("hotelicon",50);
		
	}

	public void enterSpecialCharactersForCityHOtel() {
		try {
			Generic.waitUntilElementIsClickable("entercitybutton", 50);
			Generic.performAction("inputcitytext", "@%");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	public void verifyCantFindDestinationMessage() {
		Generic.waitForObject("cantfinddestinationmessage", 20);
		String expectedCantFindMessage = Generic.findObject("cantfinddestinationmessage").getText();
		Assert.assertTrue(expectedCantFindMessage.toLowerCase().contains("can't find your destination"));
	}

}