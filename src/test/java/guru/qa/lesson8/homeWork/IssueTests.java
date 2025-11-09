package guru.qa.lesson8.homeWork;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class IssueTests {

    private static final String REPOSITORY = "qa-guru/qa_guru_14_10/issues";
    private static final String NAME_OF_ISSUE = "Issue for Autotest";

    @BeforeAll
    static void setUp() {
        Configuration.browser = "edge";
        Configuration.baseUrl = "https://github.com/";
    }


    @Test
    void nameOfIssueWithListenerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(REPOSITORY);
        $(withText(NAME_OF_ISSUE)).should(Condition.exist);
    }

    @Test
    void nameOfIssueWithLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем проверяемую страницу: " + REPOSITORY, () -> {
            open(REPOSITORY);
        });
        step("Проверяем название issue: " + NAME_OF_ISSUE, () -> {
            $(withText(NAME_OF_ISSUE)).should(Condition.exist);
        });
    }

    @Test
    public void issueAnnotatedTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        IssueWebSteps steps = new IssueWebSteps();
        steps.openCheckingPage(REPOSITORY);
        steps.checkSomethingToPage(NAME_OF_ISSUE);
    }


}
