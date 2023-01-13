package checkoutTests;

import methods.CheckoutInformationMethods;
import org.testng.annotations.Test;
import pages.CheckoutCompletePage;
import pages.OverviewPage;
import data.DataCreator;

/**
 * SuccessfulCheckoutTest is a test class that completes shopping process.
 * <p>
 * This test class extends the {@link BaseCheckoutTest} class which sets up the browser
 * and navigates to the checkout page.
 */

public class SuccessfulCheckoutTest extends BaseCheckoutTest{
    /**
     * Completes a shopping procedure.
     * It fills in the necessary information on the checkout information page,
     * clicks the finish button on the overview page,
     * and verifies that the "back home" button is present on the checkout complete page.
     */
    @Test(testName = "Successful shopping procedure.")
    public void performShoppingCheckout() {
        CheckoutInformationMethods checkoutInformationMethods = new CheckoutInformationMethods(driver);
        checkoutInformationMethods.performFillingInfo(
                DataCreator.firstName,
                DataCreator.lastName,
                DataCreator.zipCode);
        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.isFinishButtonPresent();
        overviewPage.finishShopping();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutCompletePage.isBackHomeButtonPresent();
    }

}
