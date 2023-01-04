package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PropertyManager;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public By usernameFieldBy = By.id("user-name");
    public By passwordFieldBy = By.id("password");
    public static By loginButtonBy = By.id("login-button");
    public By errorMessageBy = By.xpath("//div[@class='error-message-container error']");
    public static String validUsername(){
        return PropertyManager.getInstance().getValidUsername();
    }
    public static String validPassword(){
        return PropertyManager.getInstance().getValidPassword();
    }
    public static String invalidUsername(){
        return PropertyManager.getInstance().getInvalidUsername();
    }
    public static String invalidPassword(){
        return PropertyManager.getInstance().getInvalidPassword();
    }

    public void writeUsername(String username){
        writeText(usernameFieldBy, username);
    }

    public void writePassword(String password){
        writeText(passwordFieldBy, password);
    }

    public void clickLogin(){
        clickElement(loginButtonBy);
    }

    public void loginCheck(){
        isElementDisplayed(ShopPage.addToCartButtonBy);
    }

    public String readErrorMessage(){
        return readText(errorMessageBy);
    }

}
