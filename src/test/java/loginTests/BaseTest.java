package loginTests;

import common.Browsers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.BasePage;

/**
 * The BaseTest class contains the basic setup and tear-down methods that are run before and after each test.
 * It is responsible for initializing the WebDriver instance based on the browser specified in the testng.xml file
 * and navigating to the website's URL.
 * It extends {@link Browsers} class.
 */

public class BaseTest extends Browsers {

    /**
     * The setup method is annotated with {@code @BeforeMethod} and {@code @Parameters("browser")}.
     * This method is run before each test. It gets the specified browser from the testng.xml file and
     * initializes the WebDriver instance accordingly.
     * Also, it navigates to the website's URL.
     *
     * @param browser The name of the browser to be used for the test, as specified in the various testng.xml files
     *                located in the 'suites' folder.
     */
    @Parameters({"browser"})
    @BeforeMethod
    public void setup(String browser){
        switch (browser.toLowerCase()) {
            case "chrome" -> startChrome();
            case "firefox" -> startFirefox();
            case "edge" -> startEdge();
            default -> startChrome();
        }
        driver.get(BasePage.validUrl);
    }

    /**
     * The tearDown method is annotated with {@code @AfterMethod}.
     * This method is run after each test, and it's responsible for closing the browser.
     */
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
