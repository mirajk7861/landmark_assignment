package applicationPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.flightsearch.libraries.Generic;

public class HotelSearchResultsPage {

	public int mismatchPropertyTypeCount = 0;
	public int rateFilterResultsMismatch = 0;
	public int safetyMismatchCount = 0;
	public void verifyHotelSearchPageDisplayed() {
		String actualheader = Generic.findObject("hotelsearchpageheader").getText();
		Assert.assertTrue(actualheader.contains("Hotels, Villas, Apartments"));
	}

	public void applyFilterOnPropertyType() {
		Generic.findObjectbyScrollingDown("propertytypeapartment",1500);
		//Generic.waitForObject("propertytypeapartment", 10);
		Generic.findObject("propertytypeapartment").click();
		
	}

	public void verifyPropertyTypeFilterResults() {
		Generic.waitForObject("propertytypetagline", 10);
		List<WebElement> propertytags = Generic.findObjects("propertytypetagline");
		Generic.findObjectbyScrollingDown("propertytypetagline", 1000);
		List<String> tagTexts = new ArrayList<String>();
		for(WebElement element: propertytags) {
			tagTexts.add(element.getText());
		}
		for(String propertytype: tagTexts) {
			if(!(propertytype.toLowerCase().contains("apartment"))) {
				mismatchPropertyTypeCount++;
			}
		}	
		Assert.assertEquals(mismatchPropertyTypeCount,0,"Search results contain property not matching Apartment type ");
	}

	public void applyFilterForUserRatings() {
		try {
		//Generic.findObjectbyScrollingDown("userratingexcellent",1500);
		Generic.waitUntilElementIsClickable("userratingexcellent", 30);
//		if(Generic.isElementdisplayed("userratingexcellent")) {
//			Generic.findObject("userratingexcellent").click();
//		}
		Generic.findObjectbyScrollingDown("userratinggood",1000);
		Generic.waitUntilElementIsClickable("userratinggood", 10);
//		if(Generic.isElementdisplayed("userratinggood")) {
//			Generic.findObject("userratinggood").click();
//		}
		}catch(Exception ex) {
		Assert.fail(ex.getMessage());	
		}
		
	}

	public void verifyUserRatedHotelsDisplayed() {
		//Generic.findObjectbyScrollingDown("ratingvaluesdisplayed",800);
		List<WebElement> ratingsDisplayed = Generic.findObjects("ratingvaluesdisplayed");
		List<String> ratings = new ArrayList<String>();
		for(WebElement ele: ratingsDisplayed ) {
			ratings.add(ele.getText());
		}
		for(String rate: ratings) {
			if(!(rate.contains("4"))) {
				rateFilterResultsMismatch++;
			}
		}
		if(rateFilterResultsMismatch > 0)
			Assert.fail("rate filter results not displayed as expected : mismtach count: "+ rateFilterResultsMismatch);
	}

	public void applySafetyFilter() {
		try {
		Generic.findObjectbyScrollingDown("safeandhygienefilter", 1500);
		if(Generic.isElementdisplayed("safeandhygienefilter")) {
			Generic.click("safeandhygienefilter");
		}
		}catch(Exception ex){
			Assert.fail(ex.getMessage());
		}
	}

	public void verifySafetyAssuredHotelsDisplayed() {
		Generic.waitForObject("taglineforhygiene", 10);
		List<WebElement> safetyTaglines = Generic.findObjects("taglineforhygiene");
		List<String> hygieneTagLines = new ArrayList<String>();
		for(WebElement ele: safetyTaglines) {
			hygieneTagLines.add(ele.getText());
		}
		for(String s: hygieneTagLines) {
			if(s.toLowerCase().contains("safe")|| s.toLowerCase().contains("touchless")|| s.toLowerCase().contains("self")) {
				continue;
			}
			else {
				safetyMismatchCount++;
			}
		}
		if(safetyMismatchCount > 0) {
			Assert.fail("safety hygiene filter results have mismatch results , count:"+ safetyMismatchCount);
		}
	}
}
