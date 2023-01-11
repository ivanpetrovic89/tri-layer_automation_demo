package testsWithLoggedInUser;

import methods.ShopMethods;
import methods.ShoppingCartMethods;
import org.testng.annotations.Test;

/**
 * AddMinMaxCostToCart is a test class that contains a TestNG test for adding items with the minimum and
 * maximum prices to the cart in the web application.
 * <p>
 * It extends the {@link BaseLoggedInTest} class, which should handle logging in the user before the test is run.
 * The test creates calls methods to add the item with minimum and maximum price from the cart and then checking
 * if the operation was successful.
 */

public class AddMinMaxCostToCart extends BaseLoggedInTest{
    @Test(testName = "Adding minimum and maximum price item to cart")
    public void addMinMaxToCart() {
        ShopMethods shopMethods = new ShopMethods(driver);
        shopMethods.performAddingMinMaxToCart();
        ShoppingCartMethods shoppingCartMethods = new ShoppingCartMethods(driver);
        shoppingCartMethods.isMinMaxPriceItemAddedCheck(shoppingCartMethods.expectedMinPrice, shoppingCartMethods.expectedMaxPrice);
    }
}
