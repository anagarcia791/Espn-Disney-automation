package tests.steps.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.mobile.ConfigMobileCapabilities;
import utils.mobile.DriverForMobile;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * MobileHooks class
 */
public class MobileHooks {
    private static DriverForMobile driver;

    /**
     * Before hook for make initial set up
     */
    @Before
    public void initialSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigMobileCapabilities.deviceSetUp(capabilities);
        ConfigMobileCapabilities.applicationSetUp(capabilities);
        try {
            driver = new DriverForMobile(new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * After hook for closing the app.
     */
    @After
    public void tearDown() {
        driver.getDriver().quit();
    }

    /**
     * Gets the current driver.
     *
     * @return : WebDriver instance
     */
    public static AndroidDriver<AndroidElement> getDriver() {
        return driver.getDriver();
    }
}
