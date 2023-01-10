package methods;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginMethods extends LoginPage {
    public LoginMethods(WebDriver driver) {
        super(driver);
    }

    /**
     * Method that performs login by writing the given username and password on the login page
     * and click the login button.
     *
     * @param  username  the text to be written to the username field
     * @param  password  the text to be written to the password field
     */
    public void performLogin(String username, String password) {
        writeUsername(username);
        writePassword(password);
        clickLogin();
    }

    /**
     * Method that compares the error message displayed with the expected one after failed login attempt
     *
     * @param  expectedText  the expected error message displayed on the login page
     */
    public void failedLoginCheck(String expectedText){
        LoginPage loginPage = new LoginPage(driver);
        assertStringsEqual(loginPage.readErrorMessage(), expectedText);
    }
}
