package methods;

import org.openqa.selenium.WebDriver;
import pages.CheckoutInformationPage;

public class CheckoutInformationMethods extends CheckoutInformationPage {
    public CheckoutInformationMethods(WebDriver driver) {
        super(driver);
    }
    public void performFillingInfo(String firstName, String lastName, String zipCode){
        fillFirstName(firstName);
        fillLastName(lastName);
        fillZipCode(zipCode);
        clickContinue();
    }

    public void isCheckoutFailedCheck(String expectedText){
        assertStringsEqual(readCheckoutErrorMessage(), expectedText);
    }

}
