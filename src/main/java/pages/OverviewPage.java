package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage{
    public OverviewPage(WebDriver driver) {
        super(driver);
    }
    public By finishButtonBy = By.id("finish");

    public void isFinishButtonPresent(){
        isElementDisplayed(finishButtonBy);
    }

    public void finishShopping(){
        clickElement(finishButtonBy);
    }
}
