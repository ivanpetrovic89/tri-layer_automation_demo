package testsWithLoggedInUser;

import common.Browsers;
import common.DriverInterface;
import methods.LoginMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.BasePage;
import pages.LoginPage;

/**
 * Base class for tests that require a logged-in user.
 *<p>
 * This class extends the {@link Browsers} class and implements {@link DriverInterface}.
 * The {@link #setup(String)} method is annotated with
 * {@link org.testng.annotations.BeforeMethod @BeforeMethod}, and is run before
 * each test method. It takes a single parameter, "browser", which determines which
 * browser to use for the test. The {@link #tearDown()} method is annotated with
 * {@link org.testng.annotations.AfterMethod @AfterMethod}, and is run after
 * each test method. It quits the driver after test completion.
 *</p>
 */

public class BaseLoggedInTest extends Browsers implements DriverInterface {
    /**
     * Runs before each test. It gets the specified browser from the testng.xml file and
     * initializes the WebDriver instance accordingly. It navigates to the website's URL.
     * After that, it logs in with valid credentials.
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
        LoginMethods loginMethods = new LoginMethods(driver);
        loginMethods.performLogin(LoginPage.validUsername(), LoginPage.validPassword());
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
