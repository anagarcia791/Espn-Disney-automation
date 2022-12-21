package pom.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.mobile.BaseScreen;

import java.util.List;

/**
 * Category List Component, extends from {@link utils.mobile.BaseScreen}
 */
public class CategoryListComponent extends BaseScreen {

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/categorySelectHeader")
    private AndroidElement selectCategoryTitle;

    @AndroidFindBy(uiAutomator =
            "new UiSelector().resourceIdMatches(\".*listSelectorContainer\").resourceIdMatches(\".*facilityTypeTitle\")")
    private List<AndroidElement> categoriesList;

    /**
     * Constructor method for CategoryListComponent.
     *
     * @param driver : AndroidDriver
     */
    public CategoryListComponent(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Checks if Categories Title is displayed in screen.
     *
     * @return : Boolean
     */
    public Boolean selectCategoryTitleIsDisplayed() {
        return isElementAvailable(selectCategoryTitle);
    }

    /**
     * Checks if Categories are displayed in screen.
     *
     * @return : Boolean
     */
    public Boolean categoriesAreDisplayed() {
        return areListElementsDisplayed(categoriesList, 11);
    }

    /**
     * Checks if specific category is present in categories list.
     *
     * @param categoryToFind : category to find
     * @return : Boolean
     */
    public Boolean categoryIsPresent(String categoryToFind) {
        return elementIsPresentInList(categoriesList, categoryToFind);
    }
}
