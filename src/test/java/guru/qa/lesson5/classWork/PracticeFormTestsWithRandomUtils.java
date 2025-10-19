package guru.qa.lesson5.classWork;

import guru.qa.lesson4.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;

public class PracticeFormTestsWithRandomUtils extends TestBase {



    String firstName = getRandomString(10);
    String lastName = getRandomString(10) ;
    String userEmail = getRandomEmail();
    String streetAddress = getRandomAddress() ;
  // String dateOFBirth = faker.date().;


    @Test
    void FillPracticeFormTest() {
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(("Male"))).click();
        $("#userNumber").setValue("9169284215");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--020").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("Picture1.png");
        $("#currentAddress").setValue(streetAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaiselmer")).click();
        $("#submit").click();

        $(".modal-body").shouldHave(text(firstName));
        $(".modal-body").shouldHave(text(lastName));
        $(".modal-body").shouldHave(text(userEmail));
        $(".modal-body").shouldHave(text("9169284215"));
        $(".modal-body").shouldHave(text("November"));
        $(".modal-body").shouldHave(text("2000"));
        $(".modal-body").shouldHave(text("20"));
        $(".modal-body").shouldHave(text("English"));
        $(".modal-body").shouldHave(text("Reading"));
        $(".modal-body").shouldHave(text("Picture1.png"));
        $(".modal-body").shouldHave(text(streetAddress));
        $(".modal-body").shouldHave(text("Rajasthan"));
        $(".modal-body").shouldHave(text("Jaiselmer"));
    }

}
