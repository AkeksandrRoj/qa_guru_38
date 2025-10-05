package lesson_2.classWork;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.pageLoadStrategy = "eager"; // не ждет загрузки всех элементов страницы.
       // Configuration.holdBrowserOpen = true; // оставляет страницу на которой тест после окончания теста.
       // Configuration.timeout = 5000; // Интервал в миллисекундах при проверке появления отдельного элемента или элементов коллекции
    }

    @Test
    void fillFormTest() {
        open("text-box");
        $("#userName").setValue("Aleksandr");
        $("#userEmail").setValue("somethingEmail@mail.com");
        $("#currentAddress").setValue("Moscow city, Central-park street, 65-12");
        $("#permanentAddress").setValue("Something in Space");
        $("#submit").click();

        $("#output #name").shouldHave(text("Aleksandr"));
        $("#output #email").shouldHave(text("somethingEmail@mail.com"));
        $("#output #currentAddress").shouldHave(text("Moscow city, Central-park street, 65-12"));
        $("#output #permanentAddress").shouldHave(text("Something in Space"));
    }
}
