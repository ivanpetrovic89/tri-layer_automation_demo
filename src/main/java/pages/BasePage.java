package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.PropertyManager;

import java.time.Duration;
import java.util.*;

public class BasePage {

    public static WebDriver driver;
    public WebDriverWait wait;
    public static String validUrl = PropertyManager.getInstance().getUrl();

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitVisibility(By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void clickElement(By elementBy){
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public String readText(By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void writeText(By elementBy, String text){
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public void isElementDisplayed(By elementBy){
        Assert.assertTrue(driver.findElement(elementBy).isDisplayed());
    }

    public void assertStringsEqual(String actualText, String expectedText){
        Assert.assertEquals(actualText, expectedText);
    }

    public String getAttributeValue(By elementBy, String attribute){
        return driver.findElement(elementBy).getAttribute(attribute);
    }

    public WebElement selectRandomElement(By elementBy){
        List<WebElement> webElementList = driver.findElements(elementBy);
        Random random = new Random();
        int size = webElementList.size();
        int selection = random.nextInt(size-1);
        return webElementList.get(selection);
    }

    public void webElementClick(WebElement webElement){
        webElement.click();
    }

}
