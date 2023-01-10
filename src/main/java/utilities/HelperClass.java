package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class is used for methods that are unique enough for this project that can't be put anywhere else.
 * <p>
 *      This class contains mostly methods used for 'AddMinMaxCostToCart' test class. All methods are broken down
 *      to the simpler elements in order to make everything as reusable and maintainable as possible.
 * </p>
 */

public class HelperClass extends BasePage {
    public HelperClass(WebDriver driver) {
        super(driver);
    }

    /**
     * Returns HashMap with Strings for Keys and Doubles for Values. It makes its Keys and Values from lists of
     * provided web elements that are of By type.
     *
     * @param  elementForString  By element that is used for forming Key Strings
     * @param  elementForDouble  By element that is used for forming Value doubles
     * @return                   HashMap with Key strings and Value doubles
     */
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

    /**
     * Makes string that will be transformed into By type for locating Min and Max priced items
     *
     * @param  baseString   base String that's modified
     * @param  addString    String that's attached to the baseString
     * @param  target       String for replacement
     * @param  replacement  String for replacing target
     * @return              String that will be transformed into locator in other methods
     */
    public static String stringMaker(String baseString, String addString, String target, String replacement){
        String makingStrings = addString + baseString.replace(target, replacement).toLowerCase();
        return makingStrings;
    }

    /**
     * Returns String that represents the Key with minimum Value
     *
     * @param  elementForString  By element that will be used for String Keys
     * @param  elementForDouble  By element that will be used for Double Values
     * @return                   String that is the Key with the lowest price item
     */
    public static String minKeyString(By elementForString, By elementForDouble){
        return Collections.min(stringDoubleHashMap(elementForString, elementForDouble).entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    /**
     * Returns By element made from {@link HelperClass#stringMaker(String, String, String, String)} method,
     * which is used to modify minimum Key String from {@link HelperClass#minKeyString(By, By)}
     *
     * @param  baseString   base String that's modified
     * @param  addString    String that's attached to the baseString
     * @param  target       String for replacement
     * @param  replacement  String for replacing target
     * @return              By element that's used as a locator for further actions
     */
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
