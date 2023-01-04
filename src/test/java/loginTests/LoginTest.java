package loginTests;

import methods.LoginMethods;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test(testName = "Successful login with valid credentials.")
    public void login(){
        LoginMethods loginMethods = new LoginMethods(driver);
        loginMethods.performLogin(LoginPage.validUsername(), LoginPage.validPassword());
        loginMethods.loginCheck();
    }
}
