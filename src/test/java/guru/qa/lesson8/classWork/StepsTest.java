package guru.qa.lesson8.classWork;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class StepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String PULL_REQUEST = "91";

    @Test
    public void testLambdaTests() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий: " + REPOSITORY, () -> {
            $(".search-input").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Открывает таб pull-request", () -> {
            $("#pull-requests-tab").click();
        });
        step("Проверяем наличие pull-request с номером: " + PULL_REQUEST, () -> {
            $(withText(PULL_REQUEST)).shouldHave(exist);
        });
    }

    @Test
    public void StepsAnnotated() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchFOrRepository(REPOSITORY);
        steps.clickOnLinkOfRepository(REPOSITORY);
        steps.openPullRequestTab();
        steps.shouldSeePullRequestWithNumber(PULL_REQUEST);
    }


    @Test
    public void testLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
            attachment("source", webdriver().driver().source());
        });
        step("Ищем репозиторий: " + REPOSITORY, () -> {
            $(".search-input").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Открывает таб pull-request", () -> {
            $("#pull-requests-tab").click();
        });
        step("Проверяем наличие pull-request с номером: " + PULL_REQUEST, () -> {
            $(withText(PULL_REQUEST)).shouldHave(exist);
        });
    }


    @Test
    public void StepsAnnotatedAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
     steps.takeScreenShot();
    }
}
