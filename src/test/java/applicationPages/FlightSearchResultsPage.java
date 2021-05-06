package applicationPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.flightsearch.libraries.Generic;
import com.flightsearch.libraries.SuperTestNG;

public class FlightSearchResultsPage extends SuperTestNG {
	private int mismatchflightsCount = 0;
	private List<String> mismatchFlights = new ArrayList<String>();
	private static boolean nonstopfilterenabled;
	private static boolean onestopfilterenabled;
	private int stopMismatchCount = 0;
	private static boolean businessclassflightsavailable;

	public void verifyIfSearchResultsAreDisplayed() {
		try {
		Thread.sleep(7000);
		//Generic.waitForObject("resultspagesourcedestination", 10);
		List<WebElement> results = Generic.findObjects("resultspagesourcedestination");
		String expectedSource = results.get(0).getText();
		String expectedDestination = results.get(1).getText();
		Assert.assertTrue(expectedSource.toLowerCase().contains(source));
		Assert.assertTrue(expectedDestination.toLowerCase().contains(destination));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void validateFlightSearchresultspageDisplayed() {
		Generic.waitForObject("flightsearchresultsheader", 30);
		String resultsHeader = Generic.findObject("flightsearchresultsheader").getText();
		Assert.assertTrue(resultsHeader.contains("Flights from"));

	}

	public void applyFilterForAirlines() {
		try {
			if (Generic.isElementdisplayed("airlinesIndigo")) {
				Generic.toggleCheckBox("airlinesIndigo", "check");
			}
			if (Generic.isElementdisplayed("airlinesspicejet")) {
				Generic.toggleCheckBox("airlinesspicejet", "check");
			}
			if (Generic.isElementdisplayed("airlinesvistara")) {
				Generic.toggleCheckBox("airlinesvistara", "check");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyOnlySelctedAirlinesFligtsAreDisplayed() {
		List<WebElement> flightNamesDisplayed = Generic.findObjects("listofflightnamesdisplayed");
		List<String> expectedFlightNames = new ArrayList<String>();
		for (WebElement flight : flightNamesDisplayed) {
			expectedFlightNames.add(flight.getText());
		}
		for (String flightname : expectedFlightNames) {
			if (!((flightname.equalsIgnoreCase("IndiGo") || flightname.equalsIgnoreCase("Vistara")
					|| flightname.equalsIgnoreCase("spicejet")))) {
				mismatchFlights.add(flightname);
				mismatchflightsCount = mismatchflightsCount + 1;
			}
		}
		if (mismatchflightsCount > 0) {
			Assert.fail("Flights not matching the airline filter found: " + mismatchflightsCount);
		}
	}

	public void applyFilterOnStops() {
		try {
			if (Generic.isElementdisplayed("nonstopfiltercheckbox")) {
				Generic.toggleCheckBox("nonstopfiltercheckbox", "check");
				nonstopfilterenabled = true;
			}
			if (Generic.isElementdisplayed("onestopcheckbox")) {
				Generic.toggleCheckBox("onestopcheckbox", "check");
				onestopfilterenabled = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyStopsDisplayed() {
		List<WebElement> listOfStopsDisplayed = Generic.findObjects("listnumberofstopsresultsdisplayed");
		List<String> stops = new ArrayList<String>();
		for (WebElement stop : listOfStopsDisplayed) {
			stops.add(stop.getText());
		}
		if (nonstopfilterenabled && onestopfilterenabled) {
			for (String stop : stops) {
				if (!(stop.contains("Non stop") || stop.contains("1 stop"))) {
					stopMismatchCount++;
				}
			}
		} else if (nonstopfilterenabled && !onestopfilterenabled) {
			for (String stop : stops) {
				if (!(stop.contains("Non stop"))) {
					stopMismatchCount++;
				}
			}
		} else if (!nonstopfilterenabled && onestopfilterenabled) {
			for (String stop : stops) {
				if (!(stop.contains("1 stop"))) {
					stopMismatchCount++;
				}
			}
		}
		if (stopMismatchCount > 0) {
			Assert.fail("Stop filter results are not displayed as expected");
		}
	}

	public void selectTwoPassengers() {
		//Generic.waitUntilElementIsClickable("passengerandclass", 40);
		Generic.waitForObject("passengerandclass", 15);
		Generic.findObject("passengerandclass").click();
		Generic.waitForObject("twoguests", 10);
		Generic.findObject("twoguests").click();
			
	}

	public void selectBusinessClass() {
		Generic.waitForObject("travelclassbusiness",10);
		Generic.findObject("travelclassbusiness").click();
	 }

	public void clickDone() {
		Generic.waitForObject("donebutton",10);
		Generic.findObject("donebutton").click();
		
	}

	public void clickOnSearch() {
		
		try {
			if(Generic.isElementdisplayed("searchbuttonsearchresultspage")) {
				businessclassflightsavailable = true;
			Generic.click("searchbuttonsearchresultspage");
			}
		} catch (Exception e) {
			Assert.fail("business class flights not available");
		}
		
	}

	public void verifyBusinessClassFLightsDisplayed() {
		try {
		if(businessclassflightsavailable) {
			Generic.waitForObject("viewflightdetailsList", 30);
			List<WebElement> viewdetails = Generic.findObjects("viewflightdetailsList");
			viewdetails.get(0).click();
			WebElement ele = Generic.findObjectbyScrollingDown("checkinbaggage", 500);
			Thread.sleep(4000);
			String checkinbaggagebusinessflight = ele.getText();
			String weight = checkinbaggagebusinessflight.split(" ")[0];
			int actualcheckin = Integer.parseInt(weight);
			Assert.assertTrue(actualcheckin>=checkinBaggageBusiness);
		}else {
			Assert.fail("Business class flights not available");
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	
}
