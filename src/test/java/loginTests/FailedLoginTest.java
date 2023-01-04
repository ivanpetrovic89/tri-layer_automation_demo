package loginTests;

import methods.LoginMethods;
import org.testng.annotations.Test;

public class FailedLoginTest extends BaseTest{
    @Test(testName = "Failed login test with invalid credentials.",
            dataProviderClass = data.DataProvider.class, dataProvider = "failedLogin")

    public void failedLogin(String username, String password, String errorText){
        LoginMethods loginMethods = new LoginMethods(driver);
        loginMethods.performLogin(username, password);
        loginMethods.failedLoginCheck(errorText);
    }

}