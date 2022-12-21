package tests.steps.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.reporter.Reporter;
import utils.web.DriverForWeb;

/**
 * WebHooks class
 */
public class WebHooks {
    private static DriverForWeb driver;

    /**
     * Before hook for make initial set up
     */
    @Before
    public void initialSetUp() {
        String url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
        driver = new DriverForWeb();
        Reporter.info("Deleting cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info("Navigating to: " + url);
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
    }

    /**
     * After hook for tear down web-driver.
     */
    @After
    public void tearDown() {
        Reporter.info("Quitting driver");
        driver.getDriver().quit();
    }

    /**
     * Gets the current driver.
     *
     * @return : WebDriver instance
     */
    public static org.openqa.selenium.WebDriver getDriver() {
        return driver.getDriver();
    }
}
