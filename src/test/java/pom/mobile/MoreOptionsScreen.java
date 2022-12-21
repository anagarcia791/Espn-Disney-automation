package pom.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.mobile.BaseScreen;

/**
 * More Options screen,
 * extends from {@link utils.mobile.BaseScreen}
 */
public class MoreOptionsScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Privacy\")")
    private AndroidElement privacyLegalButton;

    /**
     * Constructor method for MoreOptionsScreen.
     *
     * @param driver : AndroidDriver
     */
    public MoreOptionsScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Checks if Privacy Legal Button is displayed in screen.
     *
     * @return : Boolean
     */
    public Boolean privacyLegalButtonIsDisplayed() {
        return isElementAvailable(privacyLegalButton);
    }

    /**
     * Scrolls to end more options screen.
     */
    public void scrollToEndMoreOptionsScreen(int maxSearchTries) {
        int scrollCounting = 0;
        do {
            swipeVertical(-0.5f);
            scrollCounting++;
        } while (!privacyLegalButtonIsDisplayed() && scrollCounting < maxSearchTries);
    }

    /**
     * Shows Privacy & Legal Component.
     *
     * @return {@link pom.mobile.PrivacyAndLegalComponent}
     */
    public PrivacyAndLegalComponent clickPrivacyLegalButton() {
        click(privacyLegalButton);
        return new PrivacyAndLegalComponent(driver);
    }

}
