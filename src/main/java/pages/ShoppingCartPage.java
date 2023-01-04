package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PropertyManager;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    public static By removeButtonBy = By.xpath("//button[text()='Remove']");
    public static By navigateToCartButtonBy = By.className("shopping_cart_link");
    public String expectedMinPrice = PropertyManager.getExpectedMinPrice();
    public String expectedMaxPrice = PropertyManager.getExpectedMaxPrice();

    public void isItemAddedToCartCheck(){
        isElementDisplayed(ShoppingCartPage.removeButtonBy);
    }

    public String readCartNumber(){
        return readText(navigateToCartButtonBy);
    }

}
