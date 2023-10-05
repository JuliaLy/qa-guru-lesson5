import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

        @BeforeAll
        static void beforeAll() {
            Configuration.baseUrl = "https://the-internet.herokuapp.com";
            Configuration.pageLoadStrategy = "eager";
            Configuration.browserSize = "1920x1080";
        }

       @Test
        void changeAWithBAction() {

           open("/drag_and_drop");
           $("#column-a").$("header").shouldHave(text("A"));
           $("#column-b").$("header").shouldHave(text("B"));
           actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().click().perform();
           $("#column-a").$("header").shouldHave(text("B"));
           $("#column-b").$("header").shouldHave(text("A"));
    }

        @Test
        void changeAWithBDragAndDrop() {

            open("/drag_and_drop");
            $("#column-a").dragAndDrop(to("#column-b"));
            $("#column-a").$("header").shouldHave(text("B"));
            $("#column-b").$("header").shouldHave(text("A"));

    }
}
