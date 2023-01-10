package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PropertyManager;

/**
 * This class represents a login page in a web application, providing methods for interacting with elements on the page.
 * It extends the BasePage class, which provides common methods for interacting with elements on a web page.
 */

public class LoginPage extends BasePage{
    /**
     * Constructs a new LoginPage with the given WebDriver.
     *
     * @param  driver  a WebDriver instance for interacting with the browser
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    /**
     * By object used to locate the username field on the login page.
     */
    public By usernameFieldBy = By.id("user-name");

    /**
     * By object used to locate the password field on the login page.
     */
    public By passwordFieldBy = By.id("password");

    /**
     * By object used to locate the login button on the login page.
     */
    public static By loginButtonBy = By.id("login-button");

    /**
     * By object used to locate the error message displayed when login fails.
     */
    public By errorMessageBy = By.xpath("//div[@class='error-message-container error']");

    /**
     * Retrieves the valid username from PropertyManager
     *
     * @return  a string representing the valid username
     * @see PropertyManager
     */
    public static String validUsername(){
        return PropertyManager.getInstance().getValidUsername();
    }

    /**
     * Retrieves the valid password from PropertyManager
     *
     * @return  a string representing the valid password
     * @see PropertyManager
     */
    public static String validPassword(){
        return PropertyManager.getInstance().getValidPassword();
    }

    /**
     * Retrieves the invalid username from PropertyManager
     *
     * @return  a string representing the invalid username
     * @see PropertyManager
     */
    public static String invalidUsername(){
        return PropertyManager.getInstance().getInvalidUsername();
    }

    /**
     * Retrieves the invalid password from PropertyManager
     *
     * @return  a string representing the invalid password
     * @see PropertyManager
     */
    public static String invalidPassword(){
        return PropertyManager.getInstance().getInvalidPassword();
    }

    /**
     * Writes the given text to the username field on the login page.
     *
     * @param username the text to be written to the username field
     */
    public void writeUsername(String username){
        writeText(usernameFieldBy, username);
    }

    /**
     * Writes the given text to the password field on the login page.
     *
     * @param password the text to be written to the password field
     */
    public void writePassword(String password){
        writeText(passwordFieldBy, password);
    }

    /**
     * Clicks the login button on the login page.
     */
    public void clickLogin(){
        clickElement(loginButtonBy);
    }

    /**
     * Checks if the user is logged in by checking if the add to cart button is displayed.
     */
    public void loginCheck(){
        isElementDisplayed(ShopPage.addToCartButtonBy);
    }

    /**
     * Reads the error message displayed when login fails.
     *
     * @return the error message displayed on the login page
     */
    public String readErrorMessage(){
        return readText(errorMessageBy);
    }

}
