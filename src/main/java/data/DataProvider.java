package data;

import methods.CheckoutInformationMethods;
import pages.CheckoutInformationPage;
import pages.LoginPage;

public class DataProvider {
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
