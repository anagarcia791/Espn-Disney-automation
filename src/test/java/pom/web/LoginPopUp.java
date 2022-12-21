package pom.web;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.web.BasePage;

/**
 * Login PopUp class, extends from {@link utils.web.BasePage}
 */
public class LoginPopUp extends BasePage {
    @FindBy(id = "logo")
    private WebElement espnLogoForm;

    @FindBy(id = "InputLoginValue")
    private WebElement emailInputForm;

    @FindBy(id = "InputPassword")
    private WebElement passwordInputForm;

    @FindBy(id = "BtnSubmit")
    private WebElement loginButtonSubmitForm;

    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButtonSubmitForm;

    @FindBy(id = "oneid-iframe")
    private WebElement signUpIframe;

    @FindBy(css = "#Title > span")
    private WebElement accountDeactivatedSpan;

    @FindBy(css = "#TextBlock > strong")
    private WebElement emailAccountDeactivated;

    /**
     * Constructor method for LoginPopUp.
     *
     * @param driver : WebDriver
     */
    public LoginPopUp(WebDriver driver) {
        super(driver);
    }

    /**
     * Check if login form elements are displayed.
     *
     * @return : Boolean
     */
    public Boolean areLoginFormElementsDisplayed() {
        return isElementDisplayed(espnLogoForm, 3) &&
                isElementDisplayed(emailInputForm, 3) &&
                isElementDisplayed(passwordInputForm, 3) &&
                isElementDisplayed(loginButtonSubmitForm, 3) &&
                isElementDisplayed(signUpButtonSubmitForm, 3);
    }

    /**
     * Navigate to signUp pop up.
     *
     * @return {@link pom.web.SignUpPopUp}
     */
    public SignUpPopUp clickSingUpButton() {
        clickElement(signUpButtonSubmitForm, 0);
        return new SignUpPopUp(getDriver());
    }

}
