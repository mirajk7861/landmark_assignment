package stepdefs;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.testng.annotations.AfterClass;

import com.flightsearch.libraries.Generic;
import com.flightsearch.utilities.Config;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks extends Config {

	@After(order = 0)
	public void afterScenario(Scenario scenario) {

		// validate if scenario has failed
		if (scenario.isFailed()) {
			try {

				BufferedImage bImage = ImageIO.read(new File(Generic.takeScreenshot(scenario.getName())));
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ImageIO.write(bImage, "png", bos);
				final byte[] screenshot = bos.toByteArray();
				scenario.attach(screenshot, "image/png", "image");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		driver.quit();
	}
	@AfterClass
	public void teardown() {
		driver.quit();
		
	}


}
