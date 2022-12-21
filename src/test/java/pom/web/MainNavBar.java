package pom.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.web.BasePage;

/**
 * MainNavBar component class, extends from {@link utils.web.BasePage}
 */
public class MainNavBar extends BasePage {
    @FindBy(css = ".container h1")
    private WebElement espnLogo;

    @FindBy(css = ".pillar.watch")
    private WebElement watchLink;

    @FindBy(id = "global-user-trigger")
    private WebElement userButton;

    /**
     * Constructor method for MainNavBar.
     *
     * @param driver : WebDriver
     */
    public MainNavBar(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigate to users options.
     *
     * @return {@link pom.web.UserOptions}
     */
    public UserOptions goToUserOptions() {
        isElementDisplayed(espnLogo, 3);
        isElementDisplayed(watchLink, 3);
        clickElement(userButton, 3);
        return new UserOptions(super.getDriver());
    }

    /**
     * Navigate to users watch page.
     *
     * @return {@link pom.web.WatchPage}
     */
    public WatchPage goToWatchPage() {
        super.clickElement(watchLink, 10);
        return new WatchPage(super.getDriver());
    }
}