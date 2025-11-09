package guru.qa.lesson8.classWork;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий: {repo} ")
    public void searchFOrRepository(String repo) {
        $(".search-input").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step("Кликаем по ссылке репозитория: {repo}")
    public void clickOnLinkOfRepository(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Открывает таб pull-request")
    public void openPullRequestTab() {
        $("#pull-requests-tab").click();
    }

    @Step("Проверяем наличие pull-request с номером {number}")
    public void shouldSeePullRequestWithNumber(String number) {
        $(withText(number)).shouldHave(exist);
    }

    @Attachment(value = "ScreenShot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenShot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
