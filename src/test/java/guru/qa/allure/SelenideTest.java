package guru.qa.allure;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @Test
    public void testIssueSearch(){
        open("https://github.com/");
        $("[data-action='click:qbsearch-input#handleExpand']").click();
        $("#query-builder-test").setValue("eroshenkoam/allure-example").pressEnter();

    }
}
