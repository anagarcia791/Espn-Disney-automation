package utils.mobile;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Class for capabilities configuration.
 */
public class ConfigMobileCapabilities {
    private static final JsonParser parser = new JsonParser();
    private static final String JSON_FILE_PATH = "src/test/resources/mobile_capabilities.json";
    private static final String DEVICE_NAME = "deviceName";
    private static final String PLATFORM_NAME = "platformName";
    private static final String PLATFORM_VERSION = "platformVersion";
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_ACTIVITY = "appActivity";
    private static final String APP = "app";
    private static final String AUTOMATION_NAME = "automationName";
    private static final String NO_RESET = "noReset";
    private static final String TIMEOUT = "newCommandTimeout";

    /**
     * Method for get data form JSON file.
     *
     * @param property : String
     * @return String
     */
    private static String getJsonDataProperty(String property) {
        try {
            Object obj = parser.parse(new FileReader(JSON_FILE_PATH));
            JsonObject jsonObject = (JsonObject) obj;
            return jsonObject.get(property)
                    .getAsString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Set Up application.
     *
     * @param capabilities : DesiredCapabilities
     */
    public static void applicationSetUp(DesiredCapabilities capabilities) {
        capabilities.setCapability(APP_PACKAGE, getJsonDataProperty(APP_PACKAGE));
        capabilities.setCapability(APP_ACTIVITY, getJsonDataProperty(APP_ACTIVITY));
        capabilities.setCapability(APP, getJsonDataProperty(APP));
    }

    /**
     * Device Set Up.
     *
     * @param capabilities : DesiredCapabilities
     */
    public static void deviceSetUp(DesiredCapabilities capabilities) {
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getJsonDataProperty(DEVICE_NAME));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getJsonDataProperty(PLATFORM_NAME));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getJsonDataProperty(PLATFORM_VERSION));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, getJsonDataProperty(AUTOMATION_NAME));
        capabilities.setCapability(MobileCapabilityType.NO_RESET, getJsonDataProperty(NO_RESET));
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, getJsonDataProperty(TIMEOUT));
    }
}
