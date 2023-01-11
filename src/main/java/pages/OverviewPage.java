package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The OverviewPage class provides methods for interacting with the overview page of a web application under test.
 * <p>
 * It extends {@link BasePage}.
 */

public class OverviewPage extends BasePage{
    /**
     * Constructs a new OverviewPage object with the specified web driver.
     *
     * @param  driver  WebDriver instance that will be used to interact with the page
     */
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    /**
     * By variable used to locate the 'Finish' button on the page.
     */
    public By finishButtonBy = By.id("finish");

    /**
     * Checks if the finish button is present on the page.
     */
    public void isFinishButtonPresent(){
        isElementDisplayed(finishButtonBy);
    }

    /**
     * Clicks on the 'Finish' button on the overview page
     */
    public void finishShopping(){
        clickElement(finishButtonBy);
    }

}
