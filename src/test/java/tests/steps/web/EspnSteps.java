package tests.steps.web;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import pom.web.*;
import org.testng.Assert;
import utils.reporter.Reporter;

/**
 * Espn Steps class
 */
public class EspnSteps {
    private MainNavBar mainNavBar;
    private UserOptions userOptions;
    private WatchPage watchPage;
    private static String EMAIL = "test-email-0-@gmail.com";

    private void setNewEmail() {
        int randomValue = (int) (Math.random() * 2000);
        EMAIL = "test-email-" + randomValue + "-@gmail.com";
    }

    @Given("User opens ESPN page")
    public void userOpensESPNPage() {
        this.mainNavBar = new MainNavBar(WebHooks.getDriver());
    }

    @When("User is successful signed up {string} {string} {string}")
    public void userIsSuccessfulSignedUp(String name, String lastname, String password) {
        userOptions = mainNavBar.goToUserOptions();
        LoginPopUp loginPopUp = userOptions.clickLoginButton();

        Reporter.info("Expected condition login components displayed");
        loginPopUp.areLoginFormElementsDisplayed();

        SignUpPopUp signUpPopUp = loginPopUp.clickSingUpButton();

        Reporter.info("Expected condition sign up components displayed");
        signUpPopUp.areSignUpFormElementsDisplayed();

        setNewEmail();
        Reporter.info("New email for account creation: " + EMAIL);
        signUpPopUp.fillSingUpInputs(name, lastname, EMAIL, password);
        signUpPopUp.clickConfirmSingUpButton();
    }

    @And("User goes to watch page")
    public void userGoesToWatchPage() {
        Reporter.info("Navigating to: watch page");
        watchPage = mainNavBar.goToWatchPage();
    }

    @Then("Watch page must be displayed")
    public void watchPageMustBeDisplayed() {
        Reporter.info("Validate watch page components are displayed");
        Assert.assertTrue(watchPage.areWatchPageElementsDisplayed(), "Watch page is not displayed");

        Reporter.info("Validate title is present in each carousel card");
        Assert.assertTrue(watchPage.isCarouselCardsTitleDisplayed(), "Title cards are not displayed");

        watchPage.clickCarouselCard(1);
        Reporter.info("Validate choose supplier frame is present");
        Assert.assertTrue(watchPage.isExitFromChooseSupplierBtnDisplayed(), "Choose supplier frame is not displayed");
        watchPage.clickExitFromChooseSupplier();
    }

    @And("User returns to home page, and should still connected {string}")
    public void userReturnsToHomePageAndShouldStillConnected(String name) {
        Reporter.info("Navigating to: home page");
        watchPage.goToPreviousPage();

        userOptions = mainNavBar.goToUserOptions();
        Reporter.info("Validate user still connected");
        Assert.assertEquals(userOptions.getUsernameLogged(), (name + "!"), "User is not connected");
    }

    @And("User logs out from session")
    public void userLogsOutFromSession() {
        Reporter.info("Logout action");
        userOptions.clickLogoutButton();
        userOptions.reloadPage();

        userOptions = mainNavBar.goToUserOptions();
        Reporter.info("Validate user is disconnected");
        Assert.assertTrue(userOptions.isUserDisconnected(), "User still connected");
    }
}
