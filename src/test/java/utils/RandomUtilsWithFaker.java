package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtilsWithFaker {

    public static Faker faker = new Faker(new Locale("en-GB"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String userGender = faker.options().option("Male", "Female", "Other");
    public String userPhone = faker.phoneNumber().subscriberNumber(10);
    public String day = String.format("%s", faker.number().numberBetween(10, 28));
    public String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    public String year = String.format("%s", faker.number().numberBetween(1900, 2025));
    public String userObject = faker.options().option("English", "Math", "geography");
    public String userHobbies = faker.options().option("Sports", "Reading", "Music");
    public String userAddress = faker.address().fullAddress();
    public String userPicture = faker.options().option("Picture1.png", "Picture2.png", "Picture3.png");
    public String userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String userCity = selectCity(userState);


    public static String selectCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }

}
