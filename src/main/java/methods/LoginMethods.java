package methods;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginMethods extends LoginPage {
    public LoginMethods(WebDriver driver) {
        super(driver);
    }

    public void performLogin(String username, String password) {
        writeUsername(username);
        writePassword(password);
        clickLogin();
    }
    public void failedLoginCheck(String expectedText){
        LoginPage loginPage = new LoginPage(driver);
        assertStringsEqual(loginPage.readErrorMessage(), expectedText);
    }
}
