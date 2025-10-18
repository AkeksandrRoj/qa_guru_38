package guru.qa.lesson4;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class PracticeFormWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void positiveFillPracticeFormTest() {

        registrationPage.openPage()
                .closeBanner()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("Something@mail.org")
                .setGender("Male")
                .setNumber("9169284215")
                .setDateOfBirth("November", "2000")
                .setSubject("English")
                .setHobby("Reading")
                .uploadPicture("Some.png")
                .setCurrentAddress("Something address")
                .setState("NCR")
                .setCity("Gurgaon")
                .clickSubmit();

        registrationPage.checkResultRegistrationForm("Student Name", "Ivan Ivanov")
                .checkResultRegistrationForm("Student Email", "Something@mail.org")
                .checkResultRegistrationForm("Gender", "Male")
                .checkResultRegistrationForm("Mobile", "9169284215")
                .checkResultRegistrationForm("Date of Birth", "20 November,2000")
                .checkResultRegistrationForm("Subjects", "English")
                .checkResultRegistrationForm("Hobbies", "Reading")
                .checkResultRegistrationForm("Picture", "Some.png")
                .checkResultRegistrationForm("Address", "Something address")
                .checkResultRegistrationForm("State and City", "NCR Gurgaon");

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
