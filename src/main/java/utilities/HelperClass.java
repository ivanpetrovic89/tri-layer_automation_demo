package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelperClass extends BasePage {
    public HelperClass(WebDriver driver) {
        super(driver);
    }

    public static HashMap<String, Double> stringDoubleHashMap(By elementForString, By elementForDouble){
        List<WebElement> allElementByOne = driver.findElements(elementForString);
        List<WebElement> allElementByTwo = driver.findElements(elementForDouble);
        String keyString;
        String valueString;
        double doubleValue;
        HashMap<String, Double> allStringDoubleHashMap = new HashMap<>();
        for (int i = 0; i < allElementByOne.size(); i++) {
            keyString = allElementByOne.get(i).getText();
            valueString = allElementByTwo.get(i).getText();
            valueString = valueString.replaceAll("[^\\d.]", "");
            doubleValue = Double.parseDouble(valueString);
            allStringDoubleHashMap.put(keyString, doubleValue);
        }
        return allStringDoubleHashMap;
    }

    public static String stringMaker(String baseString, String addString, String target, String replacement){
        String makingStrings = addString + baseString.replace(target, replacement).toLowerCase();
        return makingStrings;
    }

    public static String minKeyString(By elementForString, By elementForDouble){
        return Collections.min(stringDoubleHashMap(elementForString, elementForDouble).entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    public static By minKeyElement(String baseString, String addString, String target, String replacement){
        return By.name(stringMaker(baseString, addString, target, replacement));
    }

    public static String maxKeyString(By elementForString, By elementForDouble){
        return Collections.max(stringDoubleHashMap(elementForString, elementForDouble).entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    public static By maxKeyElement(String baseString, String addString, String target, String replacement){
        return By.name(stringMaker(baseString, addString, target, replacement));
    }

    public static String minValueDoubleToString(By elementForString, By elementForDouble){
        double minValueDouble = Collections.min(stringDoubleHashMap(elementForString, elementForDouble).entrySet(), Map.Entry.comparingByValue()).getValue();
        return Double.toString(minValueDouble);
    }
    public static String minValueString(String baseString, String addString, String target, String replacement){
        return stringMaker(baseString, addString, target, replacement);
    }

    public static String maxValueDoubleToString(By elementForString, By elementForDouble){
        double maxValueDouble = Collections.max(stringDoubleHashMap(elementForString, elementForDouble).entrySet(), Map.Entry.comparingByValue()).getValue();
        return Double.toString(maxValueDouble);
    }
    public static String maxValueString(String baseString, String addString, String target, String replacement){
        return stringMaker(baseString, addString, target, replacement);
    }

}
