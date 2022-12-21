package pom.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.mobile.BaseScreen;

import java.util.List;

/**
 * Add Plans screen.
 */
public class AddPlansScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator =
            "new UiSelector().resourceIdMatches(\".*actionSheetListView\").resourceIdMatches(\".*actionSheetItemText\")")
    private List<AndroidElement> plansList;

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/filter_clear")
    private AndroidElement partySizeLabel;

    /**
     * Constructor method for AddPlansScreen.
     *
     * @param driver : AndroidDriver
     */
    public AddPlansScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Checks if specific plan is present in plan list.
     *
     * @param planToFind : plan to find
     * @return : Boolean
     */
    public Boolean planIsPresent(String planToFind) {
        return elementIsPresentInList(plansList, planToFind);
    }

    /**
     * Click the plan by position.
     *
     * @param planPosition : position of plan in plans list
     */
    public void clickPlan(int planPosition) {
        click(plansList.get(planPosition - 1));
    }

    /**
     * Checks if Party Size label is displayed in screen.
     *
     * @return : Boolean
     */
    public Boolean diningAvailabilityComponentDisplayed() {
        return isElementAvailable(partySizeLabel, 5);
    }

}
