package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertyManager is a utility class that is used to read data from a configuration file and make it available
 * for use in other parts of the application. It uses the singleton design pattern to ensure that only one instance
 * of the class is created and used throughout the application.
 */

public class PropertyManager {

    /**
     * PropertyManager type instance used in {@link PropertyManager#getInstance()} method.
     */
    private static PropertyManager instance;

    /**
     * String variable called from 'configuration.properties' file located in 'resources' folder.
     */
    private static String url, validUsername, validPassword, invalidUsername, invalidPassword, expectedMaxPrice, expectedMinPrice,
    validFirstName, validLastName, validZipCode;

    /**
     * This method returns an instance of the PropertyManager class, creating a new instance if one does not already exist.
     * It also calls the {@link PropertyManager#loadData()} method to load data from the configuration file.
     *
     * @return instance of PropertyManager
     */
    public static PropertyManager getInstance(){
        if(instance == null){
            instance = new PropertyManager();
            instance.loadData();
        }
        return instance;
    }

    /**
     * This method reads data from the 'configuration.properties' file using the {@link Properties} class.
     * It sets the values of the different properties (url, validUsername, etc.) according to the values in
     * the configuration file.
     * If an {@link IOException} occurs while reading the file, the exception is printed to the console.
     */
    private void loadData(){
        Properties properties = new Properties();
        try
        {
            FileInputStream fi = new FileInputStream("src/main/resources/configuration.properties");
            properties.load(fi);
        }catch (IOException e){
            e.printStackTrace();
        }
        url = properties.getProperty("url");
        validUsername = properties.getProperty("validUsername");
        validPassword = properties.getProperty("validPassword");
        invalidUsername = properties.getProperty("invalidUsername");
        invalidPassword = properties.getProperty("invalidPassword");
        expectedMaxPrice = properties.getProperty("expectedMaxPrice");
        expectedMinPrice = properties.getProperty("expectedMinPrice");
        validFirstName = properties.getProperty("validFirstName");
        validLastName = properties.getProperty("validLastName");
        validZipCode = properties.getProperty("validZipCode");
    }


    /**
     * Getter that returns the value of the 'url' property that was read from the configuration file.
     *
     * @return String value of url
     */
    public String getUrl(){
        return url;
    }

    /**
     * Getter that returns the value of the 'validUsername' property that was read from the configuration file.
     *
     * @return String value of validUsername
     */
    public String getValidUsername() {
        return validUsername;
    }

    /**
     * Getter that returns the value of the 'validPassword' property that was read from the configuration file.
     *
     * @return String value of validPassword
     */
    public String getValidPassword() {
        return validPassword;
    }

    /**
     * Getter that returns the value of 'invalidUsername' property that was red from the configuration file.
     *
     * @return String value of invalidUsername
     */
    public String getInvalidUsername() {
        return invalidUsername;
    }

    /**
     * Getter that returns the value of 'invalidPassword' property that was red from the configuration file.
     *
     * @return String value of invalidPassword
     */
    public String getInvalidPassword() {
        return invalidPassword;
    }

    /**
     * Getter that returns the value of 'expectedMaxPrice' property that was red from the configuration file.
     *
     * @return String value of expectedMaxPrice
     */
    public static String getExpectedMaxPrice() {
        return expectedMaxPrice;
    }

    /**
     * Getter that returns the value of 'expectedMinPrice' property that was red from the configuration file.
     *
     * @return String value of expectedMinPrice
     */
    public static String getExpectedMinPrice() {
        return expectedMinPrice;
    }

    //TODO when you finish proper data randomizer fill this javadoc
    public static String getValidFirstName() {
        return validFirstName;
    }

    //TODO when you finish proper data randomizer fill this javadoc
    public static String getValidLastName() {
        return validLastName;
    }

    //TODO when you finish proper data randomizer fill this javadoc
    public static String getValidZipCode() {
        return validZipCode;
    }
}
