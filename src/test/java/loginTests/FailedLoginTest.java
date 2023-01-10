package loginTests;

import methods.LoginMethods;
import org.testng.annotations.Test;

/**
 * FailedLoginTest is a TestNG test class that tests the login functionality of the application when invalid
 * credentials are entered. It uses the {@link LoginMethods} class to perform the login, and the
 * {@link data.DataProvider} class to provide data for the test.
 * It extends the {@link BaseTest} class.
 */

public class FailedLoginTest extends BaseTest{
    /**
     * Test method that performs a failed login using the provided invalid credentials, and verifies that the
     * expected error message is displayed.
     *
     * @param  username   The username to be used for the login attempt
     * @param  password   The password to be used for the login attempt
     * @param  errorText  The expected error message to be displayed upon login failure
     */
    @Test(testName = "Failed login test with invalid credentials.",
            dataProviderClass = data.DataProvider.class, dataProvider = "failedLogin")
    public void failedLogin(String username, String password, String errorText){
        LoginMethods loginMethods = new LoginMethods(driver);
        loginMethods.performLogin(username, password);
        loginMethods.failedLoginCheck(errorText);
    }

}
