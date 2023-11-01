import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HubTest {

    @BeforeAll
    static void BeforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.holdBrowserOpen = false;
    }
    @Test
    void searchSoftAssertions () {

    open("/selenide/selenide");
    $("#wiki-tab").click();
    $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
    $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
    $(".gh-header-title").shouldHave(text("SoftAssertions"));
    $("#user-content-3-using-junit5-extend-test-class").sibling(0).shouldHave(text(
            "@ExtendWith({SoftAssertsExtension.class})\n" +
            "class Tests {\n" +
            "  @Test\n" +
            "  void test() {\n" +
            "    Configuration.assertionMode = SOFT;\n" +
            "    open(\"page.html\");\n" +
            "\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();\n" +
            "  }\n" +
            "}"));
}
}
