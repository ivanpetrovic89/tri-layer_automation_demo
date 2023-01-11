package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The CheckoutCompletePage class provides methods for interacting with the checkout complete page of a web application
 * under test.
 * <p>
 * It extends {@link BasePage}.
 */
public class CheckoutCompletePage extends BasePage{
    /**
     * Constructs a new CheckoutCompletePage object with the specified web driver.
     *
     * @param  driver  WebDriver instance that will be used to interact with the page
     */
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    /**
     * By variable used to locate the 'Back Home' button on the page.
     */
    public By backHomeButtonBy = By.id("back-to-products");

    /**
     * Checks if the back home button is present on the page.
     */
    public void isBackHomeButtonPresent(){
        isElementDisplayed(backHomeButtonBy);
    }
}
