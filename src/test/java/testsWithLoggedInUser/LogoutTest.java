package testsWithLoggedInUser;

import methods.ShopMethods;
import org.testng.annotations.Test;

/**
 * LogoutTest is a test class that contains a TestNG test for logging out a user in the web application.
 * <p>
 * It extends the {@link BaseLoggedInTest} class, which should handle logging in the user before the test is run.
 * The test calls methods to perform logging out and verifying whether the logout was successful by checking if the
 * text of login button is present on the page.
 */

public class LogoutTest extends BaseLoggedInTest{
    /**
     * Test method for logging out.
     * It calls methods to perform logging out and verifying whether the logout was successful by checking if the
     * text of login button is present on the page.
     */
    @Test(testName = "Logout test.")
    public void logoutTest(){
        ShopMethods shopMethods = new ShopMethods(driver);
        shopMethods.performLogout();
        shopMethods.logoutCheck("Login");
    }
}
