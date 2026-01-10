import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class SelenideTest {

    @BeforeEach
    void preconditions() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-button").click();
        $("#query-builder-test").setValue("an-ursu/qa_guru_junit");
        $("#query-builder-test").submit();
        $(By.linkText("an-ursu/qa_guru_junit")).click();
        $("#issues-tab").click();
        $(withText("forTests")).should(exist);
    }
}
