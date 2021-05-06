package com.flightsearch.utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;

public class Config {
	public static final String objectpath = ".\\ObjectProperty\\MAP.properties";
	public static String browser = "IEB";
	public static String iedriver = ".\\ExeFiles\\IEDriverServer.exe";
	public static String chromedriver = ".\\ExeFiles\\chromedriver.exe";
	public static String customer = "Appium";
	public static String environment = "Web";
	public static String defaultSelectedCar = "Car";
	public static String enterusername = "Google";
	public static String SelectedCar = "SelectedCar";
	public static String expectedCarName = "Mercedes";
	public static String expected_lang_ppulated = "Ruby";
	public static String expected_user_name = "Mr. Burns";

	public static String input_password = "pass123";
	public static String input_email = "testUser@gmail.com";
	public static String input_user_name = "AppiumUser";
	public static int UserName = 0;
	public static int Email = 1;
	public static int Password = 2;
	public static String appiumdriver = System.getProperty("user.dir") + File.separator + "ExeFiles" + File.separator
			+ "selendroid-test-app.apk";
	public static String expected_reg_prog = "PHP";
	public static String expected_reg_accept = "true";
	public static String extent_config_path = ".\\ExtentConfig\\extent-config.xml";
	public static String appPackage = "io.selendroid.testapp";

	public static String Admin = ".\\TestData\\" + customer + "\\Admin.xlsx";
	public static String title = "selendroid-test-app";

	public static String APPLICATION_NAME = "Android";
	public static String PLATFORM_VERSION = "11.0";
	public static String DEVICE_NAME = "Pixel 2_New";

	public static String AUTOMATION_NAME = "UiAutomator2";
	public static String webenvironment = "Web";
	public static String url = "https://www.makemytrip.com/";
	public static WebDriver driver;
	public static String source = "delhi";
	public static String destination = "bengaluru";
	public static int checkinBaggagePremiumflight = 20;
	public static int checkinBaggageBusiness = 35;
	//public static final String BrowserStack_UserName = "mirajkhan_W4SK6H";
	//public static final String BrowerStack_AccesKey = "ZrNHJNd6Eqsm8qYxf1aF";
	//public static final String URL = "https://" + BrowserStack_UserName + ":" + BrowerStack_AccesKey + "@hub-cloud.browserstack.com/wd/hub";
	
	public static final String USERNAME = "mirajkhan_W4SK6H";
	public static final String AUTOMATE_KEY = "ZrNHJNd6Eqsm8qYxf1aF";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
}
