package pom.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.web.BasePage;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Watch Page class, extends from {@link utils.web.BasePage}
 */
public class WatchPage extends BasePage {
    @FindBy(css = "section.Carousel")
    private List<WebElement> carouselsContainer;

    @FindBy(css = "section[aria-labelledby^='bucket-40'] li")
    private List<WebElement> carouselCards;

    @FindBy(css = "h2.WatchTile__Title")
    private WebElement cardTitle;

    @FindBy(css = ".WatchTile__Meta")
    private WebElement cardSource;

    @FindBy(css = ".lightbox__closebtn")
    private WebElement exitFromChooseSupplierBtn;

    /**
     * Constructor method for WatchPage.
     *
     * @param driver : WebDriver
     */
    public WatchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Check if carousels container are displayed.
     *
     * @return : Boolean
     */
    private Boolean isCarouselsContainerDisplayed() {
        isElementDisplayed(carouselsContainer.get(0), 15);
        return carouselsContainer.size() > 0;
    }

    /**
     * Check if carousels cards are displayed.
     *
     * @return : Boolean
     */
    private Boolean areCarouselCardsDisplayed() {
        isElementDisplayed(carouselCards.get(0), 15);
        return carouselCards.size() > 0;
    }

    /**
     * Check if watch page elements are displayed.
     *
     * @return : Boolean
     */
    public Boolean areWatchPageElementsDisplayed() {
        return isCarouselsContainerDisplayed() && areCarouselCardsDisplayed();
    }

    /**
     * Check if carousel cards title are displayed.
     *
     * @return : Boolean
     */
    public Boolean isCarouselCardsTitleDisplayed() {
        List<WebElement> visibleCarouselCards = carouselCards.stream().limit(3).collect(Collectors.toList());

        AtomicInteger truthyValue = new AtomicInteger();

        visibleCarouselCards.forEach(element -> {
            if (!cardTitle.getText().equalsIgnoreCase("") &&
                    !cardSource.getText().equalsIgnoreCase("")) {
                truthyValue.addAndGet(1);
            }
        });

        return truthyValue.get() == 3;
    }

    /**
     * Click on carousel card
     *
     * @param indexCard : card index
     */
    public void clickCarouselCard(int indexCard) {
        super.clickElement(carouselCards.get(indexCard), 2);
    }

    /**
     * Check if choose supplier pop up is displayed.
     *
     * @return : Boolean
     */
    public Boolean isExitFromChooseSupplierBtnDisplayed() {
        return isElementDisplayed(exitFromChooseSupplierBtn, 15);
    }

    /**
     * Click exit button from choose supplier pop up.
     */
    public void clickExitFromChooseSupplier() {
        super.clickElement(exitFromChooseSupplierBtn, 2);
    }
}