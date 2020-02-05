package environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

 

public class EnvironmentManager {

    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        
	//	driver = new RemoteWebDriver(new URL("http://my-selenium-grid-ip:4444/wd/hub"), dc);
        WebDriver driver = new ChromeDriver();
		RunEnvironment.setWebDriver(driver);
    }

    public static void shutDownDriver() {
        RunEnvironment.getWebDriver().quit();
    }
}
