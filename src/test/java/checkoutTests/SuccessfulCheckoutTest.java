package checkoutTests;

import methods.CheckoutInformationMethods;
import org.testng.annotations.Test;
import pages.CheckoutCompletePage;
import pages.OverviewPage;

public class SuccessfulCheckoutTest extends BaseCheckoutTest{
    @Test(testName = "Successful shopping procedure.")
    public void performShoppingCheckout() {
        CheckoutInformationMethods checkoutInformationMethods = new CheckoutInformationMethods(driver);
        checkoutInformationMethods.performFillingInfo(
                checkoutInformationMethods.validFirstName,
                checkoutInformationMethods.validLastName,
                checkoutInformationMethods.validZipCode);
        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.isFinishButtonPresent();
        overviewPage.finishShopping();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutCompletePage.isBackHomeButtonPresent();
    }
}
