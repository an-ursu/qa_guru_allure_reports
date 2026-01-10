import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


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
}

