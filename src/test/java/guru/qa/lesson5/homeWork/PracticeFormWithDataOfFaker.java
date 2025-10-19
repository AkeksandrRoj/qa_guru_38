package guru.qa.lesson5.homeWork;


import guru.qa.lesson4.TestBase;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtilsWithFaker;


public class PracticeFormWithDataOfFaker extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    RandomUtilsWithFaker rf = new RandomUtilsWithFaker();

    @Test
    void positiveFillPracticeFormTest() {
        registrationPage.openPage()
                .closeBanner()
                .setFirstName(rf.firstName)
                .setLastName(rf.lastName)
                .setEmail(rf.userEmail)
                .setGender(rf.userGender)
                .setNumber(rf.userPhone)
                .setDateOfBirth(rf.day, rf.month, rf.year)
                .setSubject(rf.userObject)
                .setHobby(rf.userHobbies)
                .uploadPicture(rf.userPicture)
                .setCurrentAddress(rf.userAddress)
                .setState(rf.userState)
                .setCity(rf.userCity)
                .clickSubmit();

        registrationPage.checkResultRegistrationForm("Student Name", rf.firstName + " " + rf.lastName)
                .checkResultRegistrationForm("Student Email", rf.userEmail)
                .checkResultRegistrationForm("Gender", rf.userGender)
                .checkResultRegistrationForm("Mobile", rf.userPhone)
                .checkResultRegistrationForm("Date of Birth", rf.day + " " + rf.month + "," + rf.year)
                .checkResultRegistrationForm("Subjects", rf.userObject)
                .checkResultRegistrationForm("Hobbies", rf.userHobbies)
                .checkResultRegistrationForm("Picture", rf.userPicture)
                .checkResultRegistrationForm("Address", rf.userAddress)
                .checkResultRegistrationForm("State and City", rf.userState + " " + rf.userCity);

    }

    @Test
    void positiveMinimumRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("Something@mail.org")
                .setGender("Male")
                .setNumber("9169284215")
                .clickSubmit();

        registrationPage.checkResultRegistrationForm("Student Name", "Ivan Ivanov")
                .checkResultRegistrationForm("Gender", "Male")
                .checkResultRegistrationForm("Mobile", "9169284215");

    }

    @Test
    void negativeInvalidEmailTest() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("Somethingmail.org")
                .setGender("Male")
                .setNumber("9169284215")
                .clickSubmit();

        registrationPage.modalWindowNotShouldBeVisible();


    }

}
