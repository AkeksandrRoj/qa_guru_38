package guru.qa.lesson8.classWork;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Pull-requests в репозитории")
    @Story("Проверка pull-request")
    @Owner("Rozchkov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание  pull-request для review")
    public void testStaticLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase( t-> t.setName("Создание  pull-request для review"));
        Allure.feature("Pull-requests в репозитории");
        Allure.story("Проверка pull-request");
        Allure.label("owner", "Rozchkov");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.github.com");
    }
}




