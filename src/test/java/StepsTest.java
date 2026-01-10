import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class StepsTest {

    private static final String REPOSITORY = "an-ursu/qa_guru_junit";
    private static final String ISSUES_TEXT = "forTests";

    @BeforeEach
    void preconditions() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }


    @Test
    @Feature("Issues в репозитории")
    @Story("Создание Issues")
    @Owner("an-ursu")
    @DisplayName("В Issues отображается текст: " + ISSUES_TEXT)
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue(REPOSITORY);
            $("#query-builder-test").submit();
        });

        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });

        step("Кликаем на таб Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие текста 'forTests'.", () -> {
            $(withText("forTests")).should(exist);
        });

    }


    @Test
    @Feature("Issues в репозитории")
    @Story("Создание Issues")
    @Owner("an-ursu")
    @DisplayName("В Issues отображается текст: " + ISSUES_TEXT)
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithText(ISSUES_TEXT);
    }
}
