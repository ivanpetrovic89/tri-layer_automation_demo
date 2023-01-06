package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PropertyManager;

public class CheckoutInformationPage extends BasePage{
    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }
    public By firstNameFieldBy = By.id("first-name");
    public By lastNameFieldBy = By.id("last-name");
    public By zipCodeFiledBy = By.id("postal-code");
    public By continueButtonBy = By.id("continue");
    public String validFirstName = PropertyManager.getValidFirstName();
    public String validLastName = PropertyManager.getValidLastName();
    public String validZipCode = PropertyManager.getValidZipCode();


    public void fillFirstName(String firstName){
        writeText(firstNameFieldBy, firstName);
    }

    public void fillLastName(String lastName){
        writeText(lastNameFieldBy, lastName);
    }

    public void fillZipCode(String zipCode){
        writeText(zipCodeFiledBy, zipCode);
    }

    public void clickContinue(){
        clickElement(continueButtonBy);
    }

}
