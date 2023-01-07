package checkoutTests;

import methods.CheckoutInformationMethods;
import org.testng.annotations.Test;

public class FailedCheckoutTest extends BaseCheckoutTest{

    @Test(testName = "Failed checkout test with valid credentials.",
            dataProviderClass = data.DataProvider.class, dataProvider = "failedCheckout")

    public void failedCheckout(String firstName, String lastName, String zipCode, String errorText){
        CheckoutInformationMethods checkoutInformationMethods = new CheckoutInformationMethods(driver);
        checkoutInformationMethods.performFillingInfo(firstName, lastName, zipCode);
        checkoutInformationMethods.isCheckoutFailedCheck(errorText);
    }

}
