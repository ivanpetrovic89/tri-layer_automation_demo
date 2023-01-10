package testsWithLoggedInUser;

import common.Browsers;
import methods.LoginMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.BasePage;
import pages.LoginPage;

/**
 * Base class for tests that require a logged-in user.
 *<p>
 * This class extends the {@link Browsers} class, which provides browser-specific
 * setup and teardown methods. The {@link #setup(String)} method is annotated with
 * {@link org.testng.annotations.BeforeMethod @BeforeMethod}, and is run before
 * each test method. It takes a single parameter, "browser", which determines which
 * browser to use for the test. The {@link #tearDown()} method is annotated with
 * {@link org.testng.annotations.AfterMethod @AfterMethod}, and is run after
 * each test method. It quits the driver after test completion.
 *</p>
 * @see Browsers
 * @see LoginMethods
 * @see LoginPage
 */

public class BaseLoggedInTest extends Browsers {
    /**
     * The setup method is annotated with {@code @BeforeMethod} and {@code @Parameters("browser")}.
     * This method is run before each test. It gets the specified browser from the testng.xml file and
     * initializes the WebDriver instance accordingly.
     * Also, it navigates to the website's URL.
     * After that, it logs in with valid credentials.
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
        LoginMethods loginMethods = new LoginMethods(driver);
        loginMethods.performLogin(LoginPage.validUsername(), LoginPage.validPassword());
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
