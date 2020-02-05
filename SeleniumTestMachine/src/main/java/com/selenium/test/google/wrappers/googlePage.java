package com.selenium.test.google.wrappers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class googlePage {

	private final WebDriver		driver;
	private final WebDriverWait	wait;

	@FindBy(name = "q")
	private WebElement			searchBox;

	@FindBy(css = "input.lsb")
	private WebElement			searchButton;

	@FindBy(className = "rc")
	private List<WebElement>	searchResults;

	@FindBy(id = "foot")
	private WebElement			footer;

	@FindBy(xpath = "//DIV[@data-hveid='CAQQAA']")
	private WebElement			ciccio;

	public googlePage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 3);
	}

	public void goTo() {

		driver.get("https://www.google.com");
	}

	public void searchFor(final String text) throws InterruptedException {
		searchBox.sendKeys(text);
		// wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		// searchButton.click();
		searchBox.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("rc")));
		final String ccc = ciccio.getAttribute("data-ved").toString();
		final String ccc2 = ciccio.toString();
	}

	public List<WebElement> getResults() {
		return searchResults;
	}

}