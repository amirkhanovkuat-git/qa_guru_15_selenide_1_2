package kz.one;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {

    @Test
    void checkEnterprisePageTest() {
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1280x800";

        open("https://github.com/");

        $(byTagAndText("button", "Solutions")).hover();
        $(byTagAndText("a", "Enterprise")).click();
        $(".home-campaign-hero").shouldHave(text("Let’s build from here"));
    }

    @Test
    void dragAndDropTest() {
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1280x800";

        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void dragAndDropWithActionsTest() {
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1280x800";

        open("https://the-internet.herokuapp.com/drag_and_drop");

        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        actions().moveToElement($("#column-a")).clickAndHold()
                .moveToElement($("#column-b")).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
