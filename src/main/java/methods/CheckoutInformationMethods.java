package methods;

import org.openqa.selenium.WebDriver;
import pages.CheckoutInformationPage;

/**
 * The CheckoutInformationMethods class provides methods for interacting with the checkout information page of a
 * web application under test.
 * <p>
 * It extends {@link CheckoutInformationPage}.
 */

public class CheckoutInformationMethods extends CheckoutInformationPage {
    /**
     * Constructs a new CheckoutInformationMethods object with the specified web driver.
     *
     * @param  driver  WebDriver instance that will be used to interact with the page
     */
    public CheckoutInformationMethods(WebDriver driver) {
        super(driver);
    }

    /**
     * Fills and submits the checkout information page.
     *
     * @param  firstName  a string representation of the first name to be entered
     * @param  lastName   a string representation of the last name to be entered
     * @param  zipCode    a string representation of the zip code to be entered
     */
    public void performFillingInfo(String firstName, String lastName, String zipCode){
        fillFirstName(firstName);
        fillLastName(lastName);
        fillZipCode(zipCode);
        clickContinue();
    }

    /**
     * Asserts if an error message displayed on the checkout page is equals to the expected text.
     *
     * @param  expectedText  a string representation of the expected error message
     */
    public void isCheckoutFailedCheck(String expectedText){
        assertStringsEqual(readCheckoutErrorMessage(), expectedText);
    }

}
