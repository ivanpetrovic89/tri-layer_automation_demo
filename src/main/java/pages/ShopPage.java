package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.HelperClass;

/**
 * This class represents a shop page on a site under test, providing methods for interacting with elements on the page.
 * It contains methods for interacting with the elements on the shop page.
 * It has several By variables for the different elements on the page, as well as methods for interacting
 * with those elements, where one method covers one action on the page.
 * It extends the BasePage class.
 */

public class ShopPage extends BasePage{
    /**
     * Constructor for the ShopPage class with the given WebDriver.
     *
     * @param driver - a WebDriver instance for interacting with the browser
     */
    public ShopPage(WebDriver driver) {
        super(driver);
    }

    /**
     * By variable used to locate the burger menu button on the shop page.
     */
    public By burgerMenuButtonBy = By.id("react-burger-menu-btn");

    /**
     * By variable used to locate the logout button on the shop page.
     */
    public By logoutButtonBy = By.id("logout_sidebar_link");

    /**
     * By variable used to locate "Add to Cart" button on the shop page.
     */
    public static By addToCartButtonBy = By.xpath("//button[contains(@id,'add-to-cart')]");

    /**
     * By variable used to locate the button that navigates to the cart page.
     */
    public By navigateToCartButtonBy = By.className("shopping_cart_link");

    /**
     * By variable used to locate the inventory product name on the shop page.
     */
    public By inventoryProductNameBy = By.className("inventory_item_name");

    /**
     * By variable used to locate dollar sign element on the shop page in order to pull whole price string.
     */
    public By dollarSignBy = By.xpath("//*[text()='$']");

    /**
     * Clicks the burger menu button.
     */
    public void burgerMenuClick(){
        clickElement(burgerMenuButtonBy);
    }

    /**
     * Clicks the logout button.
     */
    public void logoutClick(){
        clickElement(logoutButtonBy);
    }

    /**
     * Returns the value attribute of the login button.
     *
     * @return the value attribute of the login button
     */
    public String getValueOfLoginButton(){
        return getAttributeValue(LoginPage.loginButtonBy, "value");
    }

    /**
     * Clicks the "Add to Cart" button.
     */
    public void addToCartClick(){
        clickElement(addToCartButtonBy);
    }


    /**
     * Clicks the "navigate to cart" button.
     */
    public void toCartClick(){
        clickElement(navigateToCartButtonBy);
    }

    /**
     * Selects a random "Add to Cart" button on the page.
     *
     * @return a WebElement object representing the selected "Add to Cart" button
     */
    public WebElement selectRandomAddToCart(){
        return selectRandomElement(addToCartButtonBy);
    }


    /**
     * Returns the minimum product name string
     * by calling the minKeyString method from the {@link HelperClass#minKeyString(By, By)} with inventoryProductNameBy
     * and dollarSignBy as parameters.
     *
     * @return the minimum product name string
     */
    public String minNameString(){
        return HelperClass.minKeyString(inventoryProductNameBy, dollarSignBy);
    }

    /**
     * Returns the minimum product name element
     * by calling the {@link HelperClass#minKeyElement(String, String, String, String)}
     * with {@link ShopPage#minNameString()} and String parameters to be modified for the
     * proper element name to match like in html of the shop page.
     *
     * @return the minimum product name element
     */
    public By minNameElement(){
        return HelperClass.minKeyElement(minNameString(), "add-to-cart-", " ", "-");
    }

    /**
     * Clicks the "Add to cart" for the lowest price product in the shop page.
     */
    public void clickMin(){
        clickElement(minNameElement());
    }

    /**
     * Returns the maximum product name string
     * by calling the minKeyString method from the {@link HelperClass#maxKeyString(By, By)} with inventoryProductNameBy
     * and dollarSignBy as parameters.
     *
     * @return the maximum product name string
     */
    public String maxNameString(){
        return HelperClass.maxKeyString(inventoryProductNameBy, dollarSignBy);
    }

    /**
     * Returns the maximum product name element
     * by calling the {@link HelperClass#maxKeyElement(String, String, String, String)}
     * with {@link ShopPage#maxNameString()} and String parameters to be modified for the
     * proper element name to match like in html of the shop page.
     *
     * @return the maximum product name element
     */
    public By maxNameElement(){
        return HelperClass.maxKeyElement(maxNameString(), "add-to-cart-", " ", "-");
    }

    /**
     * Clicks the "Add to cart" for the highest price product in the shop page.
     */
    public void clickMax() {
        clickElement(maxNameElement());
    }

    /**
     * Returns the minimum price as String type by calling the {@link HelperClass#minValueDoubleToString(By, By)}
     * with inventoryProductNameBy and dollarSignBy as parameters.
     *
     * @return the minimum price as double type
     */
    public String minPriceDoubleToString(){
        return HelperClass.minValueDoubleToString(inventoryProductNameBy, dollarSignBy);
    }

    /**
     * Returns the minimum price as string by calling the {@link HelperClass#minValueString(String, String, String, String)}
     * method with {@link ShopPage#minPriceDoubleToString()} as input that makes proper String form of the html element
     * for the minimum price.
     *
     * @return the minimum price as string
     */
    public String minPrice(){
        return HelperClass.minValueString(minPriceDoubleToString(), "$", "", "");
    }

    /**
     * Returns the maximum price as String type by calling the {@link HelperClass#maxValueDoubleToString(By, By)}
     * with inventoryProductNameBy and dollarSignBy as parameters.
     *
     * @return the maximum price as double type
     */
    public String maxPriceDoubleToString(){
        return HelperClass.maxValueDoubleToString(inventoryProductNameBy, dollarSignBy);
    }

    /**
     * Returns the maximum price as string by calling the {@link HelperClass#maxValueString(String, String, String, String)}
     * method with {@link ShopPage#maxPriceDoubleToString()} as input that makes proper String form of the html element
     * for the maximum price.
     *
     * @return the maximum price as string
     */
    public String maxPrice(){
        return HelperClass.maxValueString(maxPriceDoubleToString(), "$", "", "");
    }

}
