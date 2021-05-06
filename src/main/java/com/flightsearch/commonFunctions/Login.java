package com.flightsearch.commonFunctions;



import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.flightsearch.libraries.Generic;
import com.flightsearch.libraries.SuperTestNG;
import com.flightsearch.utilities.Config;
import com.flightsearch.utilities.ReadXL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
/*
 * Application Log In
 */
public class Login extends SuperTestNG{
	
	//Login @param: Environment
	public static void login(String environment)
	{
		
		try
		{		
			
			//Close Existing Instances of appium
//			try {
//				/*Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
//				Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");*/
//				Runtime.getRuntime().exec("TASKKILL /IM chrome.exe");
//				
//			} catch (IOException e) {
//
//				e.printStackTrace();
//			}

		if(ReadXL.XLCellValue(Admin, "Login", environment, "Browser").equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", Config.chromedriver);//webdriver.chrome.driver
		/*		ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                options.addArguments("window-size=1920x1080");*/
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "90.0");
				caps.setCapability("build", "browserstack-build-1");
				driver = new RemoteWebDriver(new URL(URL),caps);
				//driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.navigate().to(url);
			}
			if(ReadXL.XLCellValue(Admin, "Login", environment, "Browser").equals("Firefox")){
				driver=new FirefoxDriver();				
			}
			
			if(ReadXL.XLCellValue(Admin, "Login", environment, "Browser").equals("Mobile")){
				
				DesiredCapabilities capability = new DesiredCapabilities();
					  capability.setCapability(MobileCapabilityType.APPLICATION_NAME,APPLICATION_NAME);
					  capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
					  capability.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
					  capability.setCapability(MobileCapabilityType.APP, appiumdriver);
					  System.out.println("Appium path"+ appiumdriver);
					  capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
					  capability.setCapability("appActivity","io.selendroid.testapp.HomeScreenActivity");
					  capability.setCapability("autoGrantPermissions", true);
					  capability.setCapability("appPackage","io.selendroid.testapp");
					   URL appiumurl = new URL("http://127.0.0.1:4723/wd/hub");
					  driver = new AndroidDriver<MobileElement>(appiumurl,capability);
					 
					  
					  ////////////
					  
					   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				       
					    System.out.println("Launched Android App");
					  Generic.waitForObject("Continue",100);
					  if(Generic.isElementdisplayedInApp("Continue")) {
						  System.out.println("Continue element displayed");
						  //Generic.click("Continue");
						 MobileElement me = (MobileElement) driver.findElement(By.id("com.android.permissioncontroller:id/continue_button"));
						 me.click();
						 
					  }
					  Thread.sleep(1000);
					 	if(Generic.isElementdisplayedInApp("OK_Check_For_Updates")) {
						MobileElement el1 = (MobileElement) Generic.findObject("OK_Check_For_Updates");
						el1.click();
						
						System.out.println("clicked on alert ok");
					 
					  }
					  
					}
				
				
			
		}catch(Exception e)
		{
			e.printStackTrace();
			driver.close();
		}
	}
	

}

