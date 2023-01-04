package methods;

import org.openqa.selenium.WebDriver;
import pages.ShopPage;
import pages.ShoppingCartPage;

public class ShopMethods extends ShopPage {
    public ShopMethods(WebDriver driver) {
        super(driver);
    }
    public void performLogout(){
        burgerMenuClick();
        logoutClick();
    }

    public void logoutCheck(String expectedTExt){
        assertStringsEqual(getValueOfLoginButton(), expectedTExt);
    }

    public void performAddToCart(){
        addToCartClick();
    }

    public void navigateToCart(){
        toCartClick();
    }

    public void performRandomAddToCart(){
        webElementClick(selectRandomAddToCart());
    }

    public void addRandomToCartCheck(String expectedText){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        assertStringsEqual(shoppingCartPage.readCartNumber(), expectedText);
    }

    public void performAddingMinMaxToCart(){
        clickMin();
        clickMax();
    }

}
