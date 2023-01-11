package testsWithLoggedInUser;

import methods.ShopMethods;
import org.testng.annotations.Test;
import pages.ShoppingCartPage;

/**
 * AddToCartTest is a test class that contains a TestNG test for adding an item to the cart in the web application.
 * <p>
 * It extends the {@link BaseLoggedInTest} class, which will handle logging in the user before the test is run.
 * The test calls methods to perform adding an item to the cart and verifying whether the item has been added
 * to cart successfully.
 */

public class AddToCartTest extends BaseLoggedInTest{
    /**
     * Test method for adding an item to cart.
     * It calls methods to perform adding an item to the cart and verifying whether the item has been
     * added to cart successfully.
     */
    @Test(testName = "Adding item to cart test.")
    public void addToCartTest(){
        ShopMethods shopMethods = new ShopMethods(driver);
        shopMethods.performAddToCart();
        shopMethods.navigateToCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.isItemAddedToCartCheck();
    }
}
