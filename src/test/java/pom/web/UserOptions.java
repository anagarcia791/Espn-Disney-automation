package pom.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.web.BasePage;

/**
 * UserOptions component class, extends from {@link utils.web.BasePage}
 */
public class UserOptions extends BasePage {
    @FindBy(css = ".display-user")
    private WebElement userLabelOffline;

    @FindBy(css = ".display-user span")
    private WebElement userLabelOnline;

    @FindBy(css = "a[tref$='login']")
    private WebElement loginButton;

    @FindBy(css = "a[tref$='modifyAccount']")
    private WebElement espnProfileButton;

    @FindBy(css = "a[onclick*='logout']")
    private WebElement logoutButton;

    @FindBy(id = "oneid-iframe")
    private WebElement loginPopUp;

    /**
     * Constructor method for UserOptions.
     *
     * @param driver : WebDriver
     */
    public UserOptions(WebDriver driver) {
        super(driver);
    }

    /**
     * Check if user is disconnected.
     *
     * @return : Boolean
     */
    public Boolean isUserDisconnected() {
        return isElementDisplayed(userLabelOffline) && isElementDisplayed(loginButton);
    }

    /**
     * Change driver to Login PopUp DOM.
     */
    private void switchToLoginPopUpDOM() {
        isElementDisplayed(loginPopUp);
        super.getDriver().switchTo().frame(loginPopUp);
    }

    /**
     * Navigate to login popup.
     *
     * @return {@link pom.web.LoginPopUp}
     */
    public LoginPopUp clickLoginButton() {
        clickElement(loginButton, 3);
        switchToLoginPopUpDOM();
        return new LoginPopUp(getDriver());
    }

    /**
     * If user is logged returns name.
     *
     * @return : String
     */
    public String getUsernameLogged() {
        if (isElementDisplayed(userLabelOnline)) {
            return userLabelOnline.getText();
        }
        return "";
    }

    /**
     * Click logout button
     */
    public void clickLogoutButton() {
        clickElement(logoutButton, 3);
    }
}
