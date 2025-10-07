package guru.qa.lesson_1;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTest {


    @Test
    void successfulSearchTest() {
        open("https://duckduckgo.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=r1-0]").shouldHave(text("https://ru.selenide.org"));
    }
}

