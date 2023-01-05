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

    public WebDriver driver;
    public WebDriverWait wait;
    public static String validUrl = PropertyManager.getInstance().getUrl();

    public BasePage(WebDriver driver){
        this.driver = driver;
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


    public HashMap<String, Double> twoElementHashMap(By elementByOne, By elementByTwo){
        List<WebElement> allElementByOne = driver.findElements(elementByOne);
        List<WebElement> allElementByTwo = driver.findElements(elementByTwo);
        String keyString;
        String valueString;
        double doubleValue;
        HashMap<String, Double> allElementHashMap = new HashMap<>();
        for (int i = 0; i < allElementByOne.size(); i++) {
            keyString = allElementByOne.get(i).getText();
            valueString = allElementByTwo.get(i).getText();
            doubleValue = stringToDouble(valueString);
            allElementHashMap.put(keyString, doubleValue);
        }
        return allElementHashMap;
    }

    public double stringToDouble(String baseValueString){
        baseValueString = baseValueString.replaceAll("[^\\d.]", "");
        double doubleValue = Double.parseDouble(baseValueString);
        return doubleValue;
    }

    public String stringMaker(String baseString, String addString, String target, String replacement){
        String makingStrings = addString + baseString.replace(target, replacement).toLowerCase();
        return makingStrings;
    }

    public String minKeyString(By elementByOne, By elementByTwo){
        return Collections.min(twoElementHashMap(elementByOne, elementByTwo).entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    public By minKeyElement(String baseString, String addString, String target, String replacement){
        return By.name(stringMaker(baseString, addString, target, replacement));
    }

    public String maxKeyString(By elementByOne, By elementByTwo){
    return Collections.max(twoElementHashMap(elementByOne, elementByTwo).entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    public By maxKeyElement(String baseString, String addString, String target, String replacement){
        return By.name(stringMaker(baseString, addString, target, replacement));
    }

    public String minValueDoubleToString(By elementByOne, By elementByTwo){
        double minValueDouble = Collections.min(twoElementHashMap(elementByOne, elementByTwo).entrySet(), Map.Entry.comparingByValue()).getValue();
        return Double.toString(minValueDouble);
    }
    public String minValueString(String baseString, String addString, String target, String replacement){
        return stringMaker(baseString, addString, target, replacement);
    }

    public String maxValueDoubleToString(By elementByOne, By elementByTwo){
        double maxValueDouble = Collections.max(twoElementHashMap(elementByOne, elementByTwo).entrySet(), Map.Entry.comparingByValue()).getValue();
        return Double.toString(maxValueDouble);
    }
    public String maxValueString(String baseString, String addString, String target, String replacement){
        return stringMaker(baseString, addString, target, replacement);
    }


}
