package methods;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.ShopPage;
import pages.ShoppingCartPage;

/**
 * ShoppingCartMethods is a class representing the methods that perform various actions related to the Shopping Cart
 * in the web application under test.
 * <p>
 * It extends {@link BasePage}.
 */

public class ShoppingCartMethods extends ShoppingCartPage {
    /**
     * Constructor that instantiate a new object of ShoppingCartMethods class.
     *
     * @param driver WebDriver instance that will be used to interact with the page.
     */
    public ShoppingCartMethods(WebDriver driver) {
        super(driver);
    }

    /**
     * Removes the items from the cart.
     */
    public void removeFromCart(){
        clickElement(ShoppingCartPage.removeButtonBy);
    }


    /**
     * Checks if item is removed from cart.
     *
     * @param expectedText expected text of cart icon element.
     */
    public void isItemRemovedFromCartCheck(String expectedText){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        assertStringsEqual(shoppingCartPage.readCartNumber(), expectedText);
    }


    /**
     * Checks if the item with minimum and maximum price are added to the cart.
     *
     * @param expectedMinPrice min price of the item
     * @param expectedMaxPrice max price of the item
     */
    public void isMinMaxPriceItemAddedCheck(String expectedMinPrice, String expectedMaxPrice){
        ShopPage shopPage = new ShopPage(driver);
        assertStringsEqual(shopPage.minPrice(), expectedMinPrice);
        assertStringsEqual(shopPage.maxPrice(), expectedMaxPrice);
    }

}
