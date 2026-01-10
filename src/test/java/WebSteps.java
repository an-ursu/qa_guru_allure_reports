import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class WebSteps {

    private static final String REPOSITORY = "an-ursu/qa_guru_junit";

    @BeforeEach
    void preconditions() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }


    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий " + REPOSITORY)
    public void searchForRepository(String repo) {
        $(".header-search-button").click();
        $("#query-builder-test").setValue(REPOSITORY);
        $("#query-builder-test").submit();
    }

    @Step("Кликаем по ссылке репозитория " + REPOSITORY)
    public void clickOnRepository(String repo) {
        $(By.linkText(REPOSITORY)).click();
    }

    @Step("Кликаем на таб Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие текста: {text}")
    public void shouldSeeIssueWithText(String text) {


    }


    /*@Test
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

    }*/
}

