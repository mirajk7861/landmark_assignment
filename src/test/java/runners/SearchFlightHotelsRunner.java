package runners;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.flightsearch.libraries.Generic;
import com.flightsearch.libraries.SuperTestNG;
import com.flightsearch.utilities.Config;

import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions( tags = "@hotel or @airlinefilter or @hotelspecialcharacter or @searchflight or @FlightSpecialcharacter or @userrating", glue = {"stepdefs"}, plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, features = {"src/test/java/features"})
public class SearchFlightHotelsRunner extends Config{
	
}

