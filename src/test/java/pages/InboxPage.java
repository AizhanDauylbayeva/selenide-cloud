package pages;

import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class InboxPage {

    public CloudPage openCloudPage() {
        $(byTitle("Облако")).click();
        switchTo().window(1);
        return new CloudPage();
    }
}
