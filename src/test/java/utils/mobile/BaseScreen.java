package utils.mobile;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Base class for all screens operations.
 */
public abstract class BaseScreen {

    /**
     * The driver.
     */
    protected final AndroidDriver<AndroidElement> driver;
    private final WebDriverWait wait;

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     */
    public BaseScreen(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(
                driver, Duration.ofSeconds(0)), this);
    }

    /**
     * Get wait.
     *
     * @param intWait : second for explicit wait.
     * @return : WebDriverWait
     */
    private WebDriverWait getWait(Integer intWait) {
        return new WebDriverWait(driver, intWait);
    }

    /**
     * Swipe vertical.
     *
     * @param percentage of swipe
     */
    @SuppressWarnings({"rawtypes", "unused"})
    public void swipeVertical(float percentage) {
        Dimension windowSize = driver.manage().window().getSize();

        TouchAction ta = new TouchAction(driver);
        ta.press(PointOption.point((int) (windowSize.width * 0.5), (int) (windowSize.height * 0.5)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point((int) (windowSize.width * 0.5), (int) (windowSize.height * percentage)))
                .release()
                .perform();
    }

    /**
     * Wrapper for click event specifying custom wait.
     *
     * @param element : AndroidElement
     */
    public void click(AndroidElement element, int timeout) {
        getWait(timeout).until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    /**
     * Wrapper for click event.
     *
     * @param element : AndroidElement
     */
    public void click(AndroidElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    /**
     * Wrapper for Visibility event specifying custom wait,
     * should return true if element is displayed in screen, otherwise false.
     *
     * @param element : AndroidElement
     * @param timeout : int
     * @return : Boolean
     */
    public Boolean isElementAvailable(AndroidElement element, int timeout) {
        try {
            getWait(timeout).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Wrapper for Visibility event,
     * should return true if element is displayed in screen, otherwise false.
     *
     * @param element : AndroidElement
     * @return : Boolean
     */
    public Boolean isElementAvailable(AndroidElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Wrapper for Visibility of Android Elements list,
     * should return true if elements are displayed in screen, otherwise false.
     *
     * @param list                   : list to evaluate
     * @param expectedElementsAmount : expected amount of elements in list
     * @return : Boolean
     */
    public Boolean areListElementsDisplayed(List<AndroidElement> list, int expectedElementsAmount) {

        AtomicInteger truthyValue = new AtomicInteger();

        list.forEach(element -> {
            if (!element.getText().equalsIgnoreCase("")) {
                truthyValue.addAndGet(1);
            }
        });

        return truthyValue.get() == expectedElementsAmount;
    }

    /**
     * Wrapper for presence of element in a list of Android Element,
     * should return true if elements are displayed in screen, otherwise false.
     *
     * @param list          : list to evaluate
     * @param elementToFind : element to find
     * @return : Boolean
     */
    public Boolean elementIsPresentInList(List<AndroidElement> list, String elementToFind) {

        List<AndroidElement> evaluatedList =
                list.stream()
                        .filter(category -> category.getText().equalsIgnoreCase(elementToFind))
                        .collect(Collectors.toList());
        return evaluatedList.size() == 1;
    }

}

