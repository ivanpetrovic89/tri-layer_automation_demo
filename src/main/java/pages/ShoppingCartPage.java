package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PropertyManager;

/**
 * ShoppingCartPage is a class representing the shopping cart page in the site under test.
 * <p>
 * It contains all the elements and methods that interact with the shopping cart page and also implements
 * all the functionality that a user can perform on this page.
 * It extends {@link BasePage}.
 */

public class ShoppingCartPage extends BasePage{
    /**
     * Constructor that instantiate a new object of ShoppingCartPage class.
     *
     * @param driver WebDriver instance that will be used to interact with the page.
     */
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * By element to locate the remove button.
     */
    public static By removeButtonBy = By.xpath("//button[text()='Remove']");

    /**
     * By element to locate the navigate to cart button.
     */
    public static By navigateToCartButtonBy = By.className("shopping_cart_link");

    /**
     * String variable that stores expected minimum price of the item from {@link PropertyManager}.
     */
    public String expectedMinPrice = PropertyManager.getExpectedMinPrice();

    /**
     * String variable that stores expected maximum price of the item from {@link PropertyManager}.
     */
    public String expectedMaxPrice = PropertyManager.getExpectedMaxPrice();

    /**
     * By element to locate the checkout button.
     */
    public By checkoutButtonBy = By.id("checkout");

    /**
     * Check whether the remove button is displayed.
     */
    public void isItemAddedToCartCheck(){
        isElementDisplayed(ShoppingCartPage.removeButtonBy);
    }

    /**
     * Returns the text of the cart icon element.
     *
     * @return The text of the cart icon element.
     */
    public String readCartNumber(){
        return readText(navigateToCartButtonBy);
    }

    /**
     * Performs click action on checkout button.
     */
    public void goToCheckout(){
        clickElement(checkoutButtonBy);
    }

}
