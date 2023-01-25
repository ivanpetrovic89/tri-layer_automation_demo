package loginTests;

import common.Browsers;
import common.DriverInterface;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.BasePage;

/**
 * The BaseTest class contains the basic setup and tear-down methods that are run before and after each test.
 * <p>
 * It is responsible for initializing the WebDriver instance based on the browser specified in the testng.xml file
 * and navigating to the website's URL.
 * It extends {@link Browsers} class and it implements {@link DriverInterface}.
 */

public class BaseTest extends Browsers implements DriverInterface {
    /**
     * Runs before each test. It gets the specified browser from the testng.xml file and
     * initializes the WebDriver instance accordingly. It navigates to the website's URL.
     *
     * @param browser The name of the browser to be used for the test, as specified in the various testng.xml files
     *                located in the 'suites' package.
     */
    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser){
        switch (browser.toLowerCase()) {
            case "chrome" -> startChrome();
            case "firefox" -> startFirefox();
            case "edge" -> startEdge();
            default -> startChrome();
        }
        driver.get(BasePage.validUrl);
    }

    /**
     * Runs after each test, and it's responsible for closing the browser.
     */
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    /**
     * Gets driver that's used in interface for screenshot listener.
     *
     * @return WebDriver driver
     */
    public WebDriver getDriver(){
        return driver;
    }
}
