package checkoutTests;

import common.Browsers;
import common.DriverInterface;
import methods.LoginMethods;
import methods.ShopMethods;
import methods.ShoppingCartMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.BasePage;
import pages.LoginPage;

/**
 * BaseCheckoutTest is a test class that contains the setup and tear down methods for the checkout tests.
 * <p>
 * It extends {@link Browsers} class and it implements {@link DriverInterface}.
 */

public class BaseCheckoutTest extends Browsers implements DriverInterface {
    /** The setup method runs before each test method and initializes the browser specified in the testng.xml file.
     * It navigates to the website's home page, logs in, adds an item to the cart, and navigates to the checkout page.
     *
     * @param  browser  the browser to be used for the test
    */
    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("default") String browser){
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

    /**
     * Runs after each test method and quits the browser.
     */
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    /**
     * Gets driver that's used in interface for screenshot listener.
     *
     * @return WebDriver driver
     */
    public WebDriver getDriver(){
        return driver;
    }
}
