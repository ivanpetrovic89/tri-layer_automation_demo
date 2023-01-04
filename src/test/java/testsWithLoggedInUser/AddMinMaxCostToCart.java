package testsWithLoggedInUser;

import methods.ShopMethods;
import methods.ShoppingCartMethods;
import org.testng.annotations.Test;

public class AddMinMaxCostToCart extends BaseLoggedInTest{
    @Test(testName = "Adding minimum and maximum price item to cart")
    public void addMinMaxToCart() {
        ShopMethods shopMethods = new ShopMethods(driver);
        shopMethods.performAddingMinMaxToCart();
        ShoppingCartMethods shoppingCartMethods = new ShoppingCartMethods(driver);
        shoppingCartMethods.isMinMaxPriceItemAddedCheck(shoppingCartMethods.expectedMinPrice, shoppingCartMethods.expectedMaxPrice);
    }
}
