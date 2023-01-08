package checkoutTests;

import methods.CheckoutInformationMethods;
import org.testng.annotations.Test;
import pages.CheckoutCompletePage;
import pages.CheckoutInformationPage;
import pages.OverviewPage;

public class SuccessfulCheckoutTest extends BaseCheckoutTest{
    @Test(testName = "Successful shopping procedure.")
    public void performShoppingCheckout() {
        CheckoutInformationMethods checkoutInformationMethods = new CheckoutInformationMethods(driver);
        checkoutInformationMethods.performFillingInfo(
                CheckoutInformationPage.validFirstName,
                CheckoutInformationPage.validLastName,
                CheckoutInformationPage.validZipCode);
        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.isFinishButtonPresent();
        overviewPage.finishShopping();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutCompletePage.isBackHomeButtonPresent();
    }
}
