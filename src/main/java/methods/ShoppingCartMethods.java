package methods;

import org.openqa.selenium.WebDriver;
import pages.ShopPage;
import pages.ShoppingCartPage;

public class ShoppingCartMethods extends ShoppingCartPage {
    public ShoppingCartMethods(WebDriver driver) {
        super(driver);
    }

    public void removeFromCart(){
        clickElement(ShoppingCartPage.removeButtonBy);
    }

    public void isItemRemovedFromCartCheck(String expectedText){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        assertStringsEqual(shoppingCartPage.readCartNumber(), expectedText);
    }

    public void isMinMaxPriceItemAddedCheck(String expectedMinPrice, String expectedMaxPrice){
        ShopPage shopPage = new ShopPage(driver);
        assertStringsEqual(shopPage.minPrice(), expectedMinPrice);
        assertStringsEqual(shopPage.maxPrice(), expectedMaxPrice);
    }


}
