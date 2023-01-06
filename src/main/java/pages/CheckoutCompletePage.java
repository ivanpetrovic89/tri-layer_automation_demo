package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage{
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
    public By backHomeButtonBy = By.id("back-to-products");

    public void isBackHomeButtonPresent(){
        isElementDisplayed(backHomeButtonBy);
    }
}
