package common;

import org.openqa.selenium.WebDriver;

/**
 * Interface is an interface that defines a method to get the web driver.
 */

public interface Interface {
    /**
     * Get the web driver used to interact with the web page.
     *
     * @return  the WebDriver
     */
    WebDriver getDriver();
}
