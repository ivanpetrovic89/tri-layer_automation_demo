package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage extends BasePage{
    public ShopPage(WebDriver driver) {
        super(driver);
    }
    public By burgerMenuButtonBy = By.id("react-burger-menu-btn");
    public By logoutButtonBy = By.id("logout_sidebar_link");
    public static By addToCartButtonBy = By.xpath("//button[contains(@id,'add-to-cart')]");
    public By navigateToCartButtonBy = By.className("shopping_cart_link");
    public By inventoryProductNameBy = By.className("inventory_item_name");
    public By dollarSignBy = By.xpath("//*[text()='$']");

    public void burgerMenuClick(){
        clickElement(burgerMenuButtonBy);
    }

    public void logoutClick(){
        clickElement(logoutButtonBy);
    }

    public String getValueOfLoginButton(){
        return getAttributeValue(LoginPage.loginButtonBy, "value");
    }

    public void addToCartClick(){
        clickElement(addToCartButtonBy);
    }

    public void toCartClick(){
        clickElement(navigateToCartButtonBy);
    }

    public WebElement selectRandomAddToCart(){
        return selectRandomElement(addToCartButtonBy);
    }


    public String minNameString(){
        return minKeyString(inventoryProductNameBy, dollarSignBy);
    }
    public By minNameElement(){
        return minKeyElement(minNameString(), "add-to-cart-", " ", "-");
    }
    public void clickMin(){
        clickElement(minNameElement());
    }

    public String maxNameString(){
        return maxKeyString(inventoryProductNameBy, dollarSignBy);
    }
    public By maxNameElement(){
        return maxKeyElement(maxNameString(), "add-to-cart-", " ", "-");
    }
    public void clickMax() {
        clickElement(maxNameElement());
    }


    public String minPriceDoubleToString(){
        return minValueDoubleToString(inventoryProductNameBy, dollarSignBy);
    }
    public String minPrice(){
        return minValueString(minPriceDoubleToString(), "$", "", "");
    }

    public String maxPriceDoubleToString(){
        return maxValueDoubleToString(inventoryProductNameBy, dollarSignBy);
    }
    public String maxPrice(){
        return maxValueString(maxPriceDoubleToString(), "$", "", "");
    }

}
