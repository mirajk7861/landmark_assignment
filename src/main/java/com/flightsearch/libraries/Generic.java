package com.flightsearch.libraries;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.flightsearch.utilities.ReadXML;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;

public class Generic extends SuperTestNG {

	/**
	 * Method to wait for object to load in defined time
	 * 
	 * @param Web Element and time
	 */

	public static void waitForObject(String obj, int time) {

		for (int i = 1; i < time; i++) {
			WebDriverWait wait = new WebDriverWait(driver, i);
			try {
				wait.until(ExpectedConditions.visibilityOf(Generic.findObject(obj)));
				System.out.println("objtime:" + obj + " " + i);
				break;
			} catch (Exception e) {
				if (i < time) {
					continue;
				} else {
					System.out.println(obj + " object not found ");
				}
			}
		}
	}

	public static MobileElement waitForObjectInApp(final String obj, int maxTime, int pollingtime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(maxTime))
				.pollingEvery(Duration.ofMillis(pollingtime)).ignoring(NoSuchElementException.class);

		MobileElement element = wait.until(new Function<WebDriver, MobileElement>() {
			@Override
			public MobileElement apply(WebDriver t) {
				return Generic.findObjectInApp(obj);

			}
		});
		return element;
	}

	public static void waitForProgressBarToDisappearByPoling(final String obj, int maxTime, int pollingtime) {
		Wait<AndroidDriver> wait = new FluentWait<AndroidDriver>((AndroidDriver) driver).withTimeout(Duration.ofSeconds(maxTime))
				.pollingEvery(Duration.ofMillis(pollingtime)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(obj)));
	}

	/*
	 * Enter text to input box
	 * 
	 * @parm input object tag and text to be entered
	 */
	public static void enterText(String obj, String text) {
		try {
			findObject(obj).clear();
			Thread.sleep(600);
			findObject(obj).sendKeys(text);

		} catch (Exception e) {

		}
	}

	public static void enterTextInApp(String obj, String text) {
		try {
			findObjectInApp(obj).clear();
			Thread.sleep(600);
			findObjectInApp(obj).sendKeys(text);
			System.out.println("Entered text"+ text);

		} catch (Exception e) {

		}
	}

	/*
	 * Method to click a mobile app element
	 * 
	 * @parm object tag to be clicked
	 */
	public static void clickInApp(String obj) {
		try {
			switch (ReadXML.strProperty(obj)) {

			case ".id":
				findObjectInApp(obj).click();
				break;
			case ".xpath":
				findObjectInApp(obj).click();
				break;
			case ".name":
				findObjectInApp(obj).click();
				break;
			case ".accessibilityId":
				findObjectInApp(obj).click();
				break;
			}
			;

		} catch (Exception e) {

		}
	}

	public static void click(String obj) {
		try {
			switch (ReadXML.strProperty(obj)) {

			case ".id":
				findObject(obj).click();
				break;
			case ".xpath":
				findObject(obj).click();
				break;
			case ".name":
				findObject(obj).click();
				break;
			}
			;

		} catch (Exception e) {

		}
	}

	/*
	 * Method to select item in a list box
	 * 
	 * @parm list object tag and item to be selected
	 */
	public static void selectList(String obj, String item) {
		try {

			Select select = new Select(findObject(obj));
			select.selectByVisibleText(item);

			System.out.println("item:::" + item);
		} catch (Exception e) {

		}
	}

	/*
	 * Method to find an object
	 * 
	 * @parm input object tag to be identified
	 */
	public static WebElement findObject(String obj) {
		 WebElement element = null;
		try {
			Thread.sleep(2000);
		  
		
			switch (ReadXML.strProperty(obj)) {

			case ".id":
				element = driver.findElement(By.id(ReadXML.strPropertyValue(obj)));
				break;
			case ".xpath":
				element = driver.findElement(By.xpath(ReadXML.strPropertyValue(obj)));
				break;
			case ".name":
				element = driver.findElement(By.name(ReadXML.strPropertyValue(obj)));
				break;

			}
		
		} catch (Exception e) {

		}
		return element;
	}

	public static MobileElement findObjectInApp(String obj) {
		MobileElement element = null;
		try {
			switch (ReadXML.strProperty(obj)) {

			case ".id":
				element = (MobileElement) driver.findElement(MobileBy.id(ReadXML.strPropertyValue(obj)));
				break;
			case ".xpath":
				element = (MobileElement) driver.findElement(MobileBy.xpath(ReadXML.strPropertyValue(obj)));
				break;
			case ".name":
				element = (MobileElement) driver.findElement(MobileBy.name(ReadXML.strPropertyValue(obj)));
				break;
			case ".accessibilityId":
				element = (MobileElement) driver.findElement(MobileBy.AccessibilityId(ReadXML.strPropertyValue(obj)));
				break;

			}
			;
			System.out.println("Elemnt found" + obj);
		} catch (Exception e) {
				throw e;
		}
		return element;
	}

	/*
	 * Method to find objects
	 * 
	 * @parm input object tag to be identified
	 */
	public static List<WebElement> findObjects(String obj) {
		List<WebElement> elements = null;
		try {
			switch (ReadXML.strProperty(obj)) {

			case ".id":
				elements = driver.findElements(By.id(ReadXML.strPropertyValue(obj)));
				break;
			case ".xpath":
				elements = driver.findElements(By.xpath(ReadXML.strPropertyValue(obj)));
				break;
			case ".name":
				elements = driver.findElements(By.name(ReadXML.strPropertyValue(obj)));
				break;
			}
			;
			// //
		} catch (Exception e) {
			//
		}
		return elements;
	}

	public static List<WebElement> findObjectsInApp(String obj) {
		List<WebElement> elements = null;
		try {
			switch (ReadXML.strProperty(obj)) {

			case ".id":
				elements = driver.findElements(MobileBy.id(ReadXML.strPropertyValue(obj)));
				break;
			case ".xpath":
				elements = driver.findElements(MobileBy.xpath(ReadXML.strPropertyValue(obj)));
				break;
			case ".name":
				elements = driver.findElements(MobileBy.name(ReadXML.strPropertyValue(obj)));
				break;
			}
			;

		} catch (Exception e) {
			//
		}
		return elements;
	}

	/*
	 * Method to perform action on a web element
	 * 
	 * @parm input object tag to be identified and more
	 */
	public static void performActionInApp(String... args) throws Exception {
		ReadXML objxml = new ReadXML();
		String objclass = "";
		try {

			switch (objclass) {

			case "Html.INPUT.text":
				Generic.enterTextInApp(args[0], args[1]);
				break;
			case "Html.SELECT":
				Generic.clickInApp(args[0]);
				Generic.selectList(args[0], args[1]);
				break;
			case "Html.INPUT.checkbox":
				Generic.toggleCheckBox(args[0], args[1]);
				break;
			case "Html.INPUT.radio":
				Generic.clickInApp(args[0]);
				break;
			case "Html.INPUT.submit":
				Generic.clickInApp(args[0]);
				break;
			case "Html.IMG":
				Generic.clickInApp(args[0]);
				break;
			}
			;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void performAction(String... args) throws Exception {
		// ReadXML objxml = new ReadXML();
		Thread.sleep(3000);
		String objclass = "";
		try {
			objclass = ReadXML.strClass(args[0]);
			switch (objclass) {

			case "Html.INPUT.text":
				Generic.enterText(args[0], args[1]);
				break;
			case "Html.SELECT":
				Generic.click(args[0]);
				Generic.selectList(args[0], args[1]);
				break;
			case "Html.INPUT.checkbox":
				Generic.toggleCheckBox(args[0], args[1]);
				break;
			case "Html.INPUT.radio":
				Generic.click(args[0]);
				break;
			case "Html.INPUT.submit":
				Generic.click(args[0]);
				break;
			case "Html.IMG":
				Generic.click(args[0]);
				break;
			}
			;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	public static void toggleCheckBox(String strObject, String check) {
		try {

			if (check.equalsIgnoreCase("uncheck")) {
				if (!(findObject(strObject)).isSelected()) {
					System.out.println("\n Check box already Unchecked");
				} else {
					(findObject(strObject)).click();
				}
			} else {
				if (!((findObject(strObject)).isSelected())) {
					(findObject(strObject)).click();
					System.out.println("\n Checkbox is checked");
				} else {
					System.out.println("\n Check box already checked");
				}
			}

		} catch (Exception e) {
			System.out.println("\n toggleCheckBox Method is failed ");

		}
	}

	public static void toggleCheckBoxInApp(String strObject, String check) throws Exception {
		try {

			if (check.equalsIgnoreCase("uncheck")) {
				if (!(findObjectInApp(strObject)).isSelected()) {
					System.out.println("\n Check box already Unchecked");
				} else {
					(findObjectInApp(strObject)).click();
				}
			} else {
				if (!((findObjectInApp(strObject)).isSelected())) {
					(findObjectInApp(strObject)).click();
					System.out.println("\n Checkbox is checked");
				} else {
					System.out.println("\n Check box already checked");
				}
			}

		} catch (Exception e) {
			System.out.println("\n toggleCheckBox Method is failed ");
			throw new Exception(e);

		}
	}

	/*
	 * Take the Screenshot input parameter: File name
	 */
	public static String takeScreenshot(String name) {
		String screenshotpath = null;
		try {
			// String className = new Throwable().getStackTrace()[2].getClassName();
			String className = new Throwable().getMessage();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			screenshotpath = System.getProperty("user.dir") + "\\Screenshots\\" + className + "\\" + name + ".png";
			FileUtils.copyFile(scrFile, new File(screenshotpath));
			// screenshotpath = "<a href="+"\""+screenshotpath+"\""+">view</a>";
			System.out.println(screenshotpath);
			return screenshotpath;
		} catch (Exception e) {
			System.out.println("\n takeScreenshot method is Failed");
			return screenshotpath;
		}
	}

	/*
	 * Method to enterText by property value on a web element
	 * 
	 * @parm input object tag to be identified and more
	 */
	public static void enterText(String obj, String property, String text) {
		try {
			findObject(obj, property).clear();
			Thread.sleep(600);
			findObject(obj, property).sendKeys(text);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method to selectList by property value on a web element
	 * 
	 * @parm input object tag to be identified and more
	 */
	public static void selectList(String obj, String property, String item) {
		try {

			Select select = new Select(findObject(obj, property));
			select.selectByVisibleText(item);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method to findObject by property value on a web element
	 * 
	 * @parm input object tag to be identified and more
	 */
	public static WebElement findObject(String obj, String property) {
		WebElement element = null;
		try {
			switch (ReadXML.strProperty(obj)) {

			case ".id":
				element = driver.findElement(By.id(property));
				break;
			case ".xpath":
				element = driver.findElement(By.xpath(property));
				break;
			case ".name":
				element = driver.findElement(By.name(property));
				break;
			}
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	/*
	 * Method to Click by property value on a web element
	 * 
	 * @parm input object tag to be identified and more
	 */
	public static void click(String obj, String property) {
		try {
			switch (ReadXML.strProperty(obj)) {

			case ".id":
				findObject(obj, property).click();
				break;
			case ".xpath":
				findObject(obj, property).click();
				break;
			case ".name":
				findObject(obj, property).click();
				break;
			}
			;
			//
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void waitProgressBar(int time, int polling) {
		try {
			for (int i = 0; i < time; i++) {
				WebDriverWait wait = new WebDriverWait(driver, polling);
				if (wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.id("android:id/progress"))))
					break;
				else
					continue;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WebElement waitForElelmt(int time, int polling, String item1) {
		WebElement ele;
		try {
			for (int i = 0; i < time;) {
				WebDriverWait wait = new WebDriverWait(driver, polling);
				ele = wait.until(ExpectedConditions.visibilityOf(Generic.findObject(item1)));
				return ele;
			}
		} catch (Exception e) {
		}
		return null;
	}

	public static boolean isElementdisplayed(String object) throws Exception {

		Thread.sleep(4000);
		try {

			if (Generic.findObject(object).isDisplayed()) {

				return true;

			} else {

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;

	}

	public static boolean isElementdisplayedInApp(String object) throws Exception {
		Thread.sleep(4000);

		try {
			if (Generic.findObjectInApp(object).isDisplayed()) {
				System.out.println("" + object + "is displayed");
				return true;

			} else {

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;

	}

	public static void clickInApp(MobileElement link) {
		try {
			link.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void hideKeyBoard() {
		((AppiumDriver) driver).hideKeyboard();
		System.out.println("HIding keyboard");

	}

	public static MobileElement findToastElement() {
		WebDriverWait waitForToast = new WebDriverWait(driver, 25);
		waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Toast")));
		return (MobileElement) driver.findElement((By.xpath("//android.widget.Toast")));
	}

	public static void dragAndDrop(String drag, String drop) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("scroll(0, 500)");
		driver.switchTo().frame(0);
		WebElement source = Generic.findObject(drag);
		WebElement target = Generic.findObject(drop);
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();

	}

	public static void SelectMultipleItems(String... args) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 500)");

		driver.switchTo().frame(0);
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).build().perform();
		Generic.findObject(args[0]).click();
		Generic.findObject(args[1]).click();
		Generic.findObject(args[2]).click();
		action.keyUp(Keys.CONTROL).build().perform();
		driver.switchTo().defaultContent();

	}

	public static void toggleCheckBox(WebElement webElement, String check) {
		try {

			if (check.equalsIgnoreCase("uncheck")) {
				if (!webElement.isSelected()) {
					System.out.println("\n Check box already Unchecked");
				} else {
					(webElement).click();
				}
			} else {
				if (!(webElement).isSelected()) {
					webElement.click();
					System.out.println("\n Checkbox is checked");
				} else {
					System.out.println("\n Check box already checked");
				}
			}

		} catch (Exception e) {
			System.out.println("\n toggleCheckBox Method is failed ");

		}

	}

	public static void findObjectsAndPerformAction(String obj, int index) {
		driver.switchTo().frame(0);
		List<WebElement> list_Automatioc = Generic.findObjects(obj);
		list_Automatioc.get(index).click();
		driver.switchTo().defaultContent();

	}

	public static void toggleCheckBoxInFrame(WebElement webElement, String input) {
		driver.switchTo().frame(0);
		Generic.toggleCheckBox(webElement, input);
		driver.switchTo().defaultContent();
	}

	public static List<WebElement> findObjectsInFrame(String obj) {
		driver.switchTo().frame(0);
		List<WebElement> list_Automatioc = Generic.findObjects(obj);
		driver.switchTo().defaultContent();
		return list_Automatioc;
	}

	public static ApplicationState queryAppState() {
		String appId = appPackage;
		Assert.assertEquals((((AppiumDriver) driver).queryAppState(appId)), ApplicationState.NOT_RUNNING);

		return ApplicationState.NOT_RUNNING;
	}

	public static WebElement findObjectbyScrollingDown(String object, int scrollby) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("scroll(0, "+scrollby+")");
		WebElement element = Generic.findObject(object);
		return element;
	}

	public static void hover(String object) {
		Actions action = new Actions(driver);
		action.moveToElement(Generic.findObject(object)).build().perform();
	}

	public static void waitUntilElementIsClickable(String obj, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement element = Generic.findObject(obj);
		//wait.until(ExpectedConditions.elementToBeClickable(element));
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();",wait.until(ExpectedConditions.elementToBeClickable(element)));
		//return element;
	}

	


}
