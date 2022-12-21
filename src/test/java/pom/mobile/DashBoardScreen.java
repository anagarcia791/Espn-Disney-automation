package pom.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.mobile.BaseScreen;

/**
 * DashBoard screen, extends from {@link utils.mobile.BaseScreen}
 */
public class DashBoardScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*dismiss-icon\")")
    private AndroidElement dismissWelcome;

    @AndroidFindBy(id = "android:id/button2")
    private AndroidElement dismissPreferenceUpdateButton;

    @AndroidFindBy(uiAutomator =
            "new UiSelector().descriptionContains(\"Map\")")
    private AndroidElement mapButton;

    @AndroidFindBy(uiAutomator =
            "new UiSelector().descriptionContains(\"Reserve\")")
    private AndroidElement addPlansButton;

    @AndroidFindBy(uiAutomator =
            "new UiSelector().descriptionContains(\"More Options\")")
    private AndroidElement moreOptionsButton;

    /**
     * Constructor method DashBoardScreen.
     *
     * @param driver : AndroidDriver
     */
    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Dismiss PopUps to have clean dashboard.
     */
    public void dismissPopUps() {
        if (isElementAvailable(dismissWelcome, 10)) {
            click(dismissWelcome);
        }
        if (isElementAvailable(dismissPreferenceUpdateButton, 5)) {
            click(dismissPreferenceUpdateButton);
        }
    }

    /**
     * Navigate to Map Screen from DashBoard Screen.
     *
     * @return {@link pom.mobile.MapScreen}
     */
    public MapScreen goToMapScreen() {
        click(mapButton);
        return new MapScreen(driver);
    }

    /**
     * Navigate to Add Plans Screen from DashBoard Screen.
     *
     * @return {@link pom.mobile.AddPlansScreen}
     */
    public AddPlansScreen goToAddPlansScreen() {
        click(addPlansButton);
        return new AddPlansScreen(driver);
    }

    /**
     * Navigate to More Options Screen from DashBoard Screen.
     *
     * @return {@link pom.mobile.MoreOptionsScreen}
     */
    public MoreOptionsScreen goToMoreOptionsScreen() {
        click(moreOptionsButton);
        return new MoreOptionsScreen(driver);
    }

}
