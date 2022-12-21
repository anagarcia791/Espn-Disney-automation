package tests.steps.mobile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pom.mobile.*;
import utils.reporter.Reporter;

/**
 * Disney Steps class
 */
public class DisneySteps {
    private DashBoardScreen dashBoardScreen;
    private MapScreen mapScreen;
    private CategoryListComponent categoryListComponent;
    private MoreOptionsScreen moreOptionsScreen;
    private PrivacyAndLegalComponent privacyAndLegalComponent;
    private AddPlansScreen addPlansScreen;

    @Given("User is in Dashboard screen")
    public void userIsInDashboardScreen() {
        TutorialScreen tutorialScreen = new TutorialScreen(MobileHooks.getDriver());
        if (tutorialScreen.getStartedButtonIsDisplayed()) {
            tutorialScreen.startPermissionsProcess();
            dashBoardScreen = tutorialScreen.shareLocationPermissions();
        } else {
            dashBoardScreen = new DashBoardScreen(MobileHooks.getDriver());
        }
        dashBoardScreen.dismissPopUps();
    }

    @Given("User is in map screen")
    public void userIsInMapScreen() {
        Reporter.info("Start Navigation to Map Screen");
        mapScreen = dashBoardScreen.goToMapScreen();
    }

    @When("User clicks category list button")
    public void userClicksCategoryListButton() {
        Reporter.info("Expected condition Map Screen elements displayed");
        mapScreen.mapScreenElementsDisplayed();
        Reporter.info("Click on Category List");
        categoryListComponent = mapScreen.clickCategoryListComponent();
    }

    @Then("Categories, including hotels option should be displayed")
    public void categoriesIncludingHotelsOptionShouldBeDisplayed() {
        Reporter.info("Validate Categories Title is displayed");
        Assert.assertTrue(categoryListComponent.selectCategoryTitleIsDisplayed(), "Categories List is not displayed");

        Reporter.info("Validate Categories are displayed");
        Assert.assertTrue(categoryListComponent.categoriesAreDisplayed(), "Categories are not displayed");

        Reporter.info("Validate Hotels is displayed");
        Assert.assertTrue(categoryListComponent.categoryIsPresent("Hotels"), "Hotels option is not displayed");
    }

    @Given("User is in more options screen")
    public void userIsInMoreOptionsScreen() {
        Reporter.info("Start Navigation to More Options Screen");
        moreOptionsScreen = dashBoardScreen.goToMoreOptionsScreen();
    }

    @When("User selects privacy & legal option")
    public void userSelectsPrivacyLegalOption() {
        Reporter.info("Scroll to end More Options Screen action");
        moreOptionsScreen.scrollToEndMoreOptionsScreen(4);

        Reporter.info("Click in Privacy & Legal for more info");
        privacyAndLegalComponent = moreOptionsScreen.clickPrivacyLegalButton();
    }

    @Then("Privacy & Legal options should be displayed")
    public void privacyLegalOptionsShouldBeDisplayed() {
        Reporter.info("Validate Privacy & Legal Title is displayed");
        Assert.assertTrue(privacyAndLegalComponent.privacyLegalTitleTitleIsDisplayed(), "Privacy & Legal List is not displayed");

        Reporter.info("Validate Privacy & Legal elements are displayed");
        Assert.assertTrue(privacyAndLegalComponent.privacyLegalElementsAreDisplayed(), "Privacy elements are not displayed");
    }

    @Given("User is in add plans screen")
    public void userIsInAddPlansScreen() {
        Reporter.info("Start Navigation to Add Plans Screen");
        addPlansScreen = dashBoardScreen.goToAddPlansScreen();
    }

    @When("User selects dining availability option")
    public void userSelectsDiningAvailabilityOption() {
        Reporter.info("Expected condition Check Dining Availability Button is displayed");
        addPlansScreen.planIsPresent("Check Dining Availability");
        Reporter.info("Click in Dining Availability option");
        addPlansScreen.clickPlan(1);
    }

    @Then("The party size option should be displayed")
    public void thePartySizeOptionShouldBeDisplayed() {
        Reporter.info("Validate Dining Availability Component is displayed");
        Assert.assertTrue(addPlansScreen.diningAvailabilityComponentDisplayed(), "Dining Availability Component is not displayed");
    }
}
