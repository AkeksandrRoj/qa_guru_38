package guru.qa.lesson6.classWork;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WebTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";

    }

    @BeforeEach
    void setUp() {
        open("https://duckduckgo.com/");

    }
   @ValueSource(strings = {"Selenide","junit 5"})
    @ParameterizedTest
    @Tag("Bloker")
    @DisplayName("Должен возвращать не пустой список по запросу 'selenide")
    void searchListOfLinksWithInputSelenideTest(String searchQuery) {
        $("[name=q]").setValue(searchQuery).pressEnter();
        $$("[data-testid='mainline'] li[data-layout='organic']").shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

//    @Tag("Bloker")
//    @DisplayName("Должен возвращать не пустой список картинок по запросу 'selenide")
//    @Test
//    void successfulSearchListOfPicturesTest() {
//        $("[name=q]").setValue("selenide").pressEnter();
//        $("#header_wrapper").$(byText("Изображения")).click();
//        $$("[data-testid='mainline'] li[data-layout='organic']").shouldBe(CollectionCondition.sizeGreaterThan(0));
//    }

    @Tag("Bloker")
    @DisplayName("Должен возвращать не пустой список по запросу 'junit 5")
    @Test
    void searchListOfLinksWithInputJUnitTest() {
        $("[name=q]").setValue("junit 5").pressEnter();
        $$("[data-testid='mainline'] li[data-layout='organic']").shouldBe(CollectionCondition.sizeGreaterThan(0));
    }
    @Test
    void successfulSearchTest() {
        open("https://duckduckgo.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=r1-0]").shouldHave(text("https://ru.selenide.org"));
    }

}


