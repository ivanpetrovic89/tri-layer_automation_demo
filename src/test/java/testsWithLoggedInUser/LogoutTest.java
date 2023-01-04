package testsWithLoggedInUser;

import methods.ShopMethods;
import org.testng.annotations.Test;

public class LogoutTest extends BaseLoggedInTest{
    @Test(testName = "Logout test.")
    public void logoutTest(){
        ShopMethods shopMethods = new ShopMethods(driver);
        shopMethods.performLogout();
        shopMethods.logoutCheck("Login");
    }
}
