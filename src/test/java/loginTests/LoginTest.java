package loginTests;

import methods.LoginMethods;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * LoginTest class, contains test method for successful login with valid credentials.
 * It extends BaseTest.
 */

public class LoginTest extends BaseTest {
    /**
     * The login method runs a test that checks if a user is able to successfully log in to the application.
     * The test uses valid username and password from the LoginPage class.
     * It creates an instance of the LoginMethods class and calls the performLogin method,
     * as well as the loginCheck method for assertion that the user has been logged in successfully.
     * */
    @Test(testName = "Successful login with valid credentials.")
    public void login(){
        LoginMethods loginMethods = new LoginMethods(driver);
        loginMethods.performLogin(LoginPage.validUsername(), LoginPage.validPassword());
        loginMethods.loginCheck();
    }
}
