package common;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class is used to initiate different browser based on user's need in various base test classes.
 * <p>
 *     Available browsers are: Chrome, Firefox and Edge.
 *     They can be stated in various suites under (parameter name="browser" value="state_the_browser_here")
 * </p>
 * @see loginTests.BaseTest
 * @see testsWithLoggedInUser.BaseLoggedInTest
 * @see checkoutTests.BaseCheckoutTest
 */

public class Browsers {
    /**
     * A WebDriver instance for interacting with the browser
     */
    public WebDriver driver;

    /**
     * Start Chrome browser.
     */
    public void startChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
    }

    /**
     * Start Firefox browser.
     */
    public void startFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    /**
     * Start Edge browser.
     */
    public void startEdge(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
}

