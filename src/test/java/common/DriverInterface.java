package common;

import org.openqa.selenium.WebDriver;

/**
 * DriverInterface is an interface that defines a method to get the web driver.
 */

public interface DriverInterface {
    /**
     * Get the web driver used to interact with the web page.
     *
     * @return  the WebDriver
     */
    WebDriver getDriver();
}
