package pom.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import utils.mobile.BaseScreen;


import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

/**
 * Map screen, extends from {@link utils.mobile.BaseScreen}
 */
public class MapScreen extends BaseScreen {

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/filterTitle")
    private AndroidElement filterButton;

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/categoryTitle")
    private AndroidElement categoriesButton;

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/toggleTitle")
    private AndroidElement showListButton;

    /**
     * Constructor method for MapScreen.
     *
     * @param driver the driver
     */
    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Checks if Map Screen Elements are displayed in screen.
     *
     * @return : Boolean
     */
    public Boolean mapScreenElementsDisplayed() {
        return isElementAvailable(filterButton) &&
                isElementAvailable(categoriesButton) &&
                isElementAvailable(showListButton);
    }

    /**
     * Shows Categories List Component.
     *
     * @return {@link pom.mobile.CategoryListComponent}
     */
    public CategoryListComponent clickCategoryListComponent() {
        click(categoriesButton);
        return new CategoryListComponent(driver);
    }

}
