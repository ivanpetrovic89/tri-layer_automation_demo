package data;

import pages.CheckoutInformationPage;
import pages.LoginPage;

/**
 * DataProvider is a class that provides data for TestNG test classes.
 * <p>
 *    It contains two data providers, one for "failedLogin" and another for "failedCheckout".
 *    The data provider methods returns a 2D array of objects,
 *    where each sub-array represents a set of test data.
 * </p>

 */

public class DataProvider {
    /**
     * Data provider method that returns test data for failed login tests. The test data includes invalid usernames,
     * invalid passwords, and the expected error messages to be displayed upon login failure.
     *
     * @return 2D array of objects, where each sub-array represents a set of test data (username, password, expected error message)
     */
    @org.testng.annotations.DataProvider(name = "failedLogin")
    public static Object[][] failedLoginData(){
        return new Object[][] {
                {LoginPage.invalidUsername(), LoginPage.invalidPassword(),"Epic sadface: Username and password do not match any user in this service"},
                {LoginPage.validUsername(), LoginPage.invalidPassword(),"Epic sadface: Username and password do not match any user in this service"},
                {LoginPage.invalidUsername(), LoginPage.validPassword(),"Epic sadface: Username and password do not match any user in this service"},
                {"","","Epic sadface: Username is required"},
                {LoginPage.invalidUsername(), "","Epic sadface: Password is required"},
                {"", LoginPage.invalidPassword(),"Epic sadface: Username is required"}
        };
    }

    //TODO when you finish proper data randomizer fill this javadoc
    @org.testng.annotations.DataProvider(name = "failedCheckout")
    public static Object[][] failedCheckoutData(){
        return new Object[][]{
                {"", "", "", "Error: First Name is required"},
                {"", CheckoutInformationPage.validLastName, CheckoutInformationPage.validZipCode, "Error: First Name is required"},
                {CheckoutInformationPage.validFirstName, "", CheckoutInformationPage.validZipCode, "Error: Last Name is required"},
                {CheckoutInformationPage.validFirstName, CheckoutInformationPage.validLastName, "", "Error: Postal Code is required"}

        };
    }
}
