package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static PropertyManager instance;
    private static String url, validUsername, validPassword, invalidUsername, invalidPassword, expectedMaxPrice, expectedMinPrice;

    public static PropertyManager getInstance(){
        if(instance == null){
            instance = new PropertyManager();
            instance.loadData();
        }
        return instance;
    }

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
    }

    public String getUrl(){
        return url;
    }

    public String getValidUsername() {
        return validUsername;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public String getInvalidUsername() {
        return invalidUsername;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }

    public static String getExpectedMaxPrice() {
        return expectedMaxPrice;
    }

    public static String getExpectedMinPrice() {
        return expectedMinPrice;
    }
}
