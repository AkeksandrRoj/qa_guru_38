package guru.qa.lesson4;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void positiveFillPracticeFormTest() {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("Something@mail.org")
                .setGender("Male")
                .setNumber("9169284215")
                .setDateOfBirth("20", "November", "2000")
                .setSubject("English")
                .setHobby("Reading")
                .uploadPicture("Some.png")
                .setCurrentAddress("Something address")
                .setState("Rajasthan")
                .setCity("Jaiselmer")
                .clickSubmit();

        registrationPage.checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "Something@mail.org")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9169284215")
                .checkResult("Date of Birth", "20 November,2000")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "Some.png")
                .checkResult("Address", "Something address")
                .checkResult("State and City","Rajasthan Jaiselmer");

    }

    @Test
    void positiveMinimumRequiredFieldsTest(){
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setGender("Male")
                .setNumber("9169284215")
                .clickSubmit();

        registrationPage.checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9169284215");

    }

}
