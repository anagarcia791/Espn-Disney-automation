package pom.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.web.BasePage;

/**
 * SignUp PopUp class, extends from {@link utils.web.BasePage}
 */
public class SignUpPopUp extends BasePage {
    @FindBy(id = "Title")
    private WebElement titleSignUpForm;

    @FindBy(id = "close")
    private WebElement closeBtnSignUpForm;

    @FindBy(id = "InputFirstName")
    private WebElement nameInputSignUpForm;

    @FindBy(id = "InputLastName")
    private WebElement lastNameInputSignUpForm;

    @FindBy(id = "InputEmail")
    private WebElement emailInputSignUpForm;

    @FindBy(id = "password-new")
    private WebElement passwordInputSignUpForm;

    @FindBy(id = "BtnSubmit")
    private WebElement signUpButtonSubmitForm;

    /**
     * Constructor method for SignUpPopUp.
     *
     * @param driver : WebDriver
     */
    public SignUpPopUp(WebDriver driver) {
        super(driver);
    }

    /**
     * Check if signup form elements are displayed.
     *
     * @return : Boolean
     */
    public Boolean areSignUpFormElementsDisplayed() {
        return isElementDisplayed(titleSignUpForm, 3) &&
                isElementDisplayed(closeBtnSignUpForm, 3) &&
                isElementDisplayed(nameInputSignUpForm, 3) &&
                isElementDisplayed(lastNameInputSignUpForm, 3) &&
                isElementDisplayed(emailInputSignUpForm, 3) &&
                isElementDisplayed(passwordInputSignUpForm, 3);
    }

    /**
     * Fills singUp inputs.
     *
     * @param name     : name
     * @param lastName : last name
     * @param email    : email
     * @param password : password
     */
    public void fillSingUpInputs(String name, String lastName, String email, String password) {
        typeOnInput(nameInputSignUpForm, name, 0);
        typeOnInput(lastNameInputSignUpForm, lastName, 0);
        typeOnInput(emailInputSignUpForm, email, 0);
        typeOnInput(passwordInputSignUpForm, password, 0);
    }

    /**
     * Click on sign up button
     */
    public void clickConfirmSingUpButton() {
        isElementDisplayed(signUpButtonSubmitForm, 3);
        clickElement(signUpButtonSubmitForm, 2);
    }
}
