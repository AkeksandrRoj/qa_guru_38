package guru.qa.lesson5;

import com.codeborne.selenide.Configuration;
import guru.qa.lesson4.TestBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static guru.qa.lesson5.TestData.firstName;
import static guru.qa.lesson5.TestData.lastName;

public class PracticeFormTestsWithTestData extends TestBase {

    // String firstName = "Ivan";
    //String firstName;


//    @BeforeEach
//    void prepareTestData() {
//         firstName = "Ivan";
//    }


    @Test
    void positiveFillPracticeFormTest() {
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("Something@mail.org");
        $("#genterWrapper").$(byText(("Male"))).click();
        $("#userNumber").setValue("9169284215");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--020").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("Some.png");
        $("#currentAddress").setValue("Something address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaiselmer")).click();
        $("#submit").click();

        $(".modal-body").shouldHave(text(firstName));
        $(".modal-body").shouldHave(text("Ivanov"));
        $(".modal-body").shouldHave(text("Something@mail.org"));
        $(".modal-body").shouldHave(text("9169284215"));
        $(".modal-body").shouldHave(text("November"));
        $(".modal-body").shouldHave(text("2000"));
        $(".modal-body").shouldHave(text("20"));
        $(".modal-body").shouldHave(text("English"));
        $(".modal-body").shouldHave(text("Reading"));
        $(".modal-body").shouldHave(text("Some.png"));
        $(".modal-body").shouldHave(text("Something address"));
        $(".modal-body").shouldHave(text("Rajasthan"));
        $(".modal-body").shouldHave(text("Jaiselmer"));
    }

}
