package data;

import com.github.javafaker.Faker;

/**
 * DataCreator class uses Faker library for generating random credentials.
 */

public class DataCreator {
    static Faker faker = new Faker();

    /**
     * String variable for random first name
     */
    public static String firstName = faker.name().firstName();

    /**
     * String variable for random last name
     */
    public static String lastName = faker.name().lastName();

    /**
     * String variable for random zip code
     */
    public static String zipCode = faker.address().zipCode();

}
