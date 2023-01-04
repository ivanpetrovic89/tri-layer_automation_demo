package testsWithLoggedInUser;

import methods.ShopMethods;
import methods.ShoppingCartMethods;
import org.testng.annotations.Test;

public class RemoveFromCartTest extends BaseLoggedInTest{
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
