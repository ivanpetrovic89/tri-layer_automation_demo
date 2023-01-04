package testsWithLoggedInUser;

import methods.ShopMethods;
import org.testng.annotations.Test;

public class AddRandomItemToCart extends BaseLoggedInTest{
    @Test(testName = "Add random item to cart.")
    public void addRandomItemToCart() {
        ShopMethods shopMethods = new ShopMethods(driver);
        shopMethods.performRandomAddToCart();
        shopMethods.addRandomToCartCheck("1");
    }
}
