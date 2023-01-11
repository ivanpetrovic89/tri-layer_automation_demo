package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PropertyManager;

/**
 * CheckoutInformationPage class contains all individual variables and methods used for different actions
 * on the checkout information page of the web application under test.
 * <p>
 * It extends {@link BasePage}.
 */

public class CheckoutInformationPage extends BasePage{
    /**
     * Constructor that instantiate a new object of CheckoutInformationPage class.
     *
     * @param driver WebDriver instance that will be used to interact with the page.
     */
    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * By variable used to locate the field for the first name input.
     */
    public By firstNameFieldBy = By.id("first-name");

    /**
     * By variable used to locate the field for the last name input.
     */
    public By lastNameFieldBy = By.id("last-name");

    /**
     * By variable used to locate the field for the last name input.
     */
    public By zipCodeFiledBy = By.id("postal-code");

    /**
     * By variable used to locate 'Continue' button on the checkout information page.
     */
    public By continueButtonBy = By.id("continue");

    //TODO popravi naredne 3 linije ovo za sledeci cas
    public static String validFirstName = PropertyManager.getValidFirstName();
    public static String validLastName = PropertyManager.getValidLastName();
    public static String validZipCode = PropertyManager.getValidZipCode();

    /**
     * By variable used to locate checkout error message.
     */
    public By errorCheckoutMessageBy = By.xpath("//div[@class='error-message-container error']");


    /**
     * Fills the first name field on a web page.
     *
     * @param  firstName  a string representation of the first name to be entered.
     */
    public void fillFirstName(String firstName){
        writeText(firstNameFieldBy, firstName);
    }

    /**
     * Fills the last name field on a web page.
     *
     * @param lastName a string representation of the last name to be entered.
     */
    public void fillLastName(String lastName){
        writeText(lastNameFieldBy, lastName);
    }

    /**
     * Fills the zip code field on a web page.
     *
     * @param zipCode a string representation of the zip code to be entered.
     */
    public void fillZipCode(String zipCode){
        writeText(zipCodeFiledBy, zipCode);
    }

    /**
     * Clicks on 'Continue' button on the checkout information page.
     */
    public void clickContinue(){
        clickElement(continueButtonBy);
    }

    /**
     * Reads an error message that's displayed when we enter invalid data to the checkout information fields.
     *
     * @return a string representation of the error message displayed on the checkout page.
     */
    public String readCheckoutErrorMessage(){
        return readText(errorCheckoutMessageBy);
    }

}
