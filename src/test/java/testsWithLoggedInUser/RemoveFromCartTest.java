package testsWithLoggedInUser;

import methods.ShopMethods;
import methods.ShoppingCartMethods;
import org.testng.annotations.Test;

/**
 * RemoveFromCartTest is a test class that contains a TestNG test for removing an item from the cart in the web application.
 * <p>
 * It extends the {@link BaseLoggedInTest} class, which will handle logging in the user before the test is run.
 * The test calls methods to perform adding an item to the cart, removing it from the cart,
 * and verifying whether the item has been removed from the cart successfully.
 */

public class RemoveFromCartTest extends BaseLoggedInTest{
    /**
     * Test method for removing an item from the cart.
     * It calls methods to perform adding an item to the cart, removing it from the cart,
     * and verifying whether the item has been removed from the cart successfully.
     */
    @Test(testName = "Adding item to cart test.")
    public void addToCartTest(){
        ShopMethods shopMethods = new ShopMethods(driver);
        shopMethods.performAddToCart();
        shopMethods.navigateToCart();
        ShoppingCartMethods shoppingCartMethods = new ShoppingCartMethods(driver);
        shoppingCartMethods.removeFromCart();
        shoppingCartMethods.isItemRemovedFromCartCheck(""); // empty expectedText because there is no text in cart icon element, i.e. cart should be empty
    }
}
