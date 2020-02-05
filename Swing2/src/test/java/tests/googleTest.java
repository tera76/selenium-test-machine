package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.test.google.wrappers.googlePage;
import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

public class googleTest {

	private WebDriver driver;
	private googlePage google;

	@Before
	public void startBrowser() {
		EnvironmentManager.initWebDriver();
		driver = RunEnvironment.getWebDriver();
	}

	@Test
	public void googleTest1() throws InterruptedException {
		google = new googlePage(driver);
		google.goTo();
		google.searchFor("test");
		Assert.assertTrue(google.getResults().size() >= 2);

	}

	@After
	public void tearDown() {
		EnvironmentManager.shutDownDriver();
	}
}
