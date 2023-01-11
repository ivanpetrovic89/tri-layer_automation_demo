package checkoutTests;

import methods.CheckoutInformationMethods;
import org.testng.annotations.Test;

/**
 * FailedCheckoutTest is a test class that tests the failed checkout scenario using combination of empty data
 * and valid credentials in information fields.
 * <p>
 * It extends the {@link BaseCheckoutTest} class.
 */

public class FailedCheckoutTest extends BaseCheckoutTest{
    /**
     * Performs the test scenario by filling the information fields with combination of empty data and valid
     * credentials. After, it checks for error message.
     *
     * @param  firstName  valid first name
     * @param  lastName   valid last name
     * @param  zipCode    valid zip code
     * @param  errorText  the expected error message text.
     */
    @Test(testName = "Failed checkout test with valid credentials.",
            dataProviderClass = data.DataProvider.class, dataProvider = "failedCheckout")
    public void failedCheckout(String firstName, String lastName, String zipCode, String errorText){
        CheckoutInformationMethods checkoutInformationMethods = new CheckoutInformationMethods(driver);
        checkoutInformationMethods.performFillingInfo(firstName, lastName, zipCode);
        checkoutInformationMethods.isCheckoutFailedCheck(errorText);
    }

}
