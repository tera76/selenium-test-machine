package com.selenium.test.environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EnvironmentManager {

	public static void initWebDriver() {
		final String driverType = "FIREFOX";

		WebDriver driver = null;
		switch (driverType) {
			default:
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", "chromedriver");
				driver = new ChromeDriver();
				break;
			case "FIREFOX":
				System.setProperty("webdriver.gecko.driver", "geckodriver");
				driver = new FirefoxDriver();
				break;
		}

		RunEnvironment.setWebDriver(driver);
	}

	public static void shutDownDriver() {
		RunEnvironment.getWebDriver().quit();
	}
}
