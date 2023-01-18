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

/**
 * This class contains base methods that are used across the code in other page classes.
 * <p>
 * BasePage class is designed to be highly reusable and maintainable and in a way of common Page Object design
 * in testing it represents meta-class. In other words, it can be used in other projects with minimum of changes.
 * </p>
 */

public class BasePage {
    /**
     * A WebDriver type for BasePage constructor, and base variable used across the code for
     * interaction with the browsers.
     */
    public static WebDriver driver;

    /**
     * A WebDriverWait type for waiting methods
     */
    public WebDriverWait wait;

    /**
     * A String used for defining proper url of the app under test, pulled from PropertyManager.
     * @see PropertyManager
     */
    public static String validUrl = PropertyManager.getInstance().getUrl();

    /**
     * Constructs a new BasePage with the given WebDriver and defining wait method.
     *
     * @param  driver  a WebDriver instance for interacting with the browser.
     */
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    /**
     * Waits for the element specified by the given By object to be visible.
     *
     * @param  elementBy  a By object specifying the element to wait for
     */
    public void waitVisibility(By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    /**
     * Clicks the element specified by the given By object.
     *
     * @param  elementBy  a By object specifying the element to click
     */
    public void clickElement(By elementBy){
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    /**
     * Reads the text of the element specified by the given By object.
     *
     * @param  elementBy  a By object specifying the element to read from
     * @return            the text of the element
     */
    public String readText(By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    /**
     * Clears the text of the element specified by the given By object and writes the given text.
     *
     * @param  elementBy  a By object specifying the element to write to
     * @param  text       the text to write
     */
    public void writeText(By elementBy, String text){
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    /**
     * Asserts that the element specified by the given By object is displayed.
     *
     * @param  elementBy  a By object specifying the element to check
     */
    public void isElementDisplayed(By elementBy){
        Assert.assertTrue(driver.findElement(elementBy).isDisplayed());
    }

    /**
     * Asserts that the given actual text is equal to the given expected text.
     *
     * @param  actualText   the actual text to compare
     * @param  expectedText the expected text to compare
     */
    public void assertStringsEqual(String actualText, String expectedText){
        Assert.assertEquals(actualText, expectedText);
    }

    /**
     * Gets the value of the given attribute for the element specified by the given By object.
     *
     * @param  elementBy  a By object specifying the element to get the attribute from
     * @param  attribute  the attribute to get the value of
     * @return            the value of the attribute
     */
    public String getAttributeValue(By elementBy, String attribute){
        return driver.findElement(elementBy).getAttribute(attribute);
    }

    /**
     * Selects a random element from the list of elements specified by the given By object.
     *
     * @param  elementBy  a By object specifying the elements to select from
     * @return            a random element from the list
     */
    public WebElement selectRandomElement(By elementBy){
        List<WebElement> webElementList = driver.findElements(elementBy);
        Random random = new Random();
        int size = webElementList.size();
        int selection = random.nextInt(size);
        return webElementList.get(selection);
    }

    /**
     * Clicks the given WebElement.
     *
     * @param  webElement  the element to click
     */
    public void webElementClick(WebElement webElement){
        webElement.click();
    }

}
