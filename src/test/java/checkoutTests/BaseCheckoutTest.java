package checkoutTests;

import common.Browsers;
import methods.LoginMethods;
import methods.ShopMethods;
import methods.ShoppingCartMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.BasePage;
import pages.LoginPage;

public class BaseCheckoutTest extends Browsers {
    @Parameters({"browser"})
    @BeforeMethod
    public void setup(String browser){
        switch (browser.toLowerCase()) {
            case "chrome" -> startChrome();
            case "firefox" -> startFirefox();
            case "edge" -> startEdge();
            default -> startChrome();
        }
        driver.get(BasePage.validUrl);
        LoginMethods loginMethods = new LoginMethods(driver);
        loginMethods.performLogin(LoginPage.validUsername(), LoginPage.validPassword());
        ShopMethods shopMethods = new ShopMethods(driver);
        shopMethods.performAddToCart();
        shopMethods.navigateToCart();
        ShoppingCartMethods shoppingCartMethods = new ShoppingCartMethods(driver);
        shoppingCartMethods.goToCheckout();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
