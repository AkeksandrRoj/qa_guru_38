package guru.qa.lesson6.homeWork;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PlatiChastyamiWebTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void setUp() {
        open("https://platichastyami.ru/");
    }


    @ValueSource(strings = {"Покупателям", "Продавцам", "Магазины", "Отвечаем на вопросы"})
    @ParameterizedTest(name = "Проверка, что пункт меню {0} отображается в шапке сайта")
    void headerMenuShouldContainExpectedItem(String menuItem) {
        open("https://platichastyami.ru/");
        $$(".navigation__link").findBy(text(menuItem)).shouldBe(visible);
    }


    @CsvFileSource(resources = "/test_data/pageOfBuyersShouldContainLinkOfPartnersTest.csv")
    @ParameterizedTest(name = "Проверка, что блок партнёра {0} содержит корректную ссылку")
    void pageOfBuyersShouldContainLinkOfPartnersTest(String partnerName, String id, String expectedLink) {
        open("https://platichastyami.ru/");
        $$(".navigation__link").findBy(text("Покупателям")).click();

        $("[data-elem-id='" + id + "']")
                .$("a")
                .shouldHave(attribute("href", expectedLink))
                .shouldBe(exist);
    }

    static Stream<Arguments> pageData() {
        return Stream.of(
                Arguments.of("Покупателям", "https://platichastyami.ru/"),
                Arguments.of("Продавцам", "https://platichastyami.ru/for-partners"),
                Arguments.of("Магазины", "https://platichastyami.ru/partners"),
                Arguments.of("Отвечаем на вопросы", "https://platichastyami.ru/faq")
        );
    }

    @ParameterizedTest(name = "Логотип отображается на странице: {0}")
    @MethodSource("pageData")
    void logoShouldBeVisibleOnEachPage(String pageName, String pageUrl) {
        open(pageUrl);
        $(".logo__img").shouldBe(visible);
    }


}


