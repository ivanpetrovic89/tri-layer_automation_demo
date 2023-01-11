package methods;

import org.openqa.selenium.WebDriver;
import pages.ShopPage;
import pages.ShoppingCartPage;

/**
 * ShopMethods is a class that contains methods for interacting with the ShopPage in the web application.
 * It extends the {@link ShopPage} class and provides methods for performing specific actions on the shop page,
 * such as logging out, adding items to the cart, and checking for certain conditions.
 */

public class ShopMethods extends ShopPage {
    /**
     * Constructor for the ShopMethods class with the given WebDriver.
     *
     * @param driver - a WebDriver instance for interacting with the browser
     */
    public ShopMethods(WebDriver driver) {
        super(driver);
    }

    /**
     * Performs logout action by clicking burger menu and then logout button.
     */
    public void performLogout(){
        burgerMenuClick();
        logoutClick();
    }

    /**
     * Checks whether logout is successful by comparing the value of login button with expected text.
     *
     * @param expectedText - the expected text of the login button after logout
     */
    public void logoutCheck(String expectedText){
        assertStringsEqual(getValueOfLoginButton(), expectedText);
    }

    /**
     * Performs Add To Cart action by clicking the "Add to Cart" button.
     */
    public void performAddToCart(){
        addToCartClick();
    }

    /**
     * Navigates to the shopping cart page by clicking the "Navigate to Cart" button.
     */
    public void navigateToCart(){
        toCartClick();
    }

    /**
     * Performs adding random product to cart by clicking on a random "Add to Cart" button.
     */
    public void performRandomAddToCart(){
        webElementClick(selectRandomAddToCart());
    }

    /**
     * Checks whether adding random product to cart was successful by comparing the cart number with expected text.
     *
     * @param expectedText - the expected cart number
     */
    public void addRandomToCartCheck(String expectedText){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        assertStringsEqual(shoppingCartPage.readCartNumber(), expectedText);
    }

    /**
     * Performs adding the minimum and maximum price product to cart by clicking on the respective elements.
     */
    public void performAddingMinMaxToCart(){
        clickMin();
        clickMax();
    }

}
