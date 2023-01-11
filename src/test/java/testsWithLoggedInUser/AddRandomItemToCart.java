package testsWithLoggedInUser;

import methods.ShopMethods;
import org.testng.annotations.Test;

/**
 * AddRandomItemToCart is a test class that contains a TestNG test for adding a random item to the cart in the web application.
 * <p>
 * It extends the {@link BaseLoggedInTest} class, which will handle logging in the user before the test is run.
 * The calls methods to perform adding a random item to the cart and checking if the operation was successful.
 */

public class AddRandomItemToCart extends BaseLoggedInTest{
    /**
     * Test method for adding a random item to the cart.
     * It calls methods to perform adding a random item to the cart and checking if the operation was successful.
     */
    @Test(testName = "Add random item to cart.")
    public void addRandomItemToCart() {
        ShopMethods shopMethods = new ShopMethods(driver);
        shopMethods.performRandomAddToCart();
        shopMethods.addRandomToCartCheck("1");
    }
}
