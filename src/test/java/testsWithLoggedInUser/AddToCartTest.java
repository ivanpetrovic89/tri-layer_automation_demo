package testsWithLoggedInUser;

import methods.ShopMethods;
import org.testng.annotations.Test;
import pages.ShoppingCartPage;

public class AddToCartTest extends BaseLoggedInTest{
    @Test(testName = "Adding item to cart test.")
    public void addToCartTest(){
        ShopMethods shopMethods = new ShopMethods(driver);
        shopMethods.performAddToCart();
        shopMethods.navigateToCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.isItemAddedToCartCheck();
    }
}
