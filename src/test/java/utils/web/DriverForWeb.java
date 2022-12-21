package utils.web;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Web Driver class.
 */
public class DriverForWeb {

    private final org.openqa.selenium.WebDriver driver;

    /**
     * Constructor method for driver.
     */
    public DriverForWeb() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    /**
     * Get web driver.
     *
     * @return : WebDriver
     */
    public org.openqa.selenium.WebDriver getDriver() {
        return driver;
    }
}