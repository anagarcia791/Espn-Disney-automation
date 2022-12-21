package utils.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Mobile Driver class.
 */
public class DriverForMobile {
    private final AndroidDriver<AndroidElement> driver;

    /**
     * Constructor method for driver.
     */
    public DriverForMobile(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    /**
     * Get mobile driver.
     *
     * @return : WebDriver
     */
    public AndroidDriver<AndroidElement> getDriver() {
        return this.driver;
    }
}
