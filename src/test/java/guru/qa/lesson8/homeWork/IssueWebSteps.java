package guru.qa.lesson8.homeWork;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IssueWebSteps {

    @Step("Открываем проверяемую страницу: {page}")
    public void openCheckingPage(String page){
        open(page);
    }
    @Step("Проверяем название issue: {element}")
    public void checkSomethingToPage(String element){
        $(withText(element)).should(Condition.exist);
    }
}
