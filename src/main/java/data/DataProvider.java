package data;

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

}
