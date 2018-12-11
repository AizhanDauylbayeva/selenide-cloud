package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byXpath;

public class CloudPage {

    public void closePanel() {
        $(By.xpath("//div[@class='b-panel__close__icon']")).waitUntil(Condition.visible, 5000).click();
    }

    public PicturesFolderCloudPage openPicturesFolder() {
        $(byXpath("//div[@data-id='/Pictures']/*[@class='b-thumb__content']")).doubleClick();
        return new PicturesFolderCloudPage();
    }

    public void createFolder() {
        $(byXpath("//div[@data-group='create']")).click();
        $(byXpath("//span[contains(string(), 'Папку')]")).click();
        $(byXpath("//button[@data-name=\"add\"]")).click();
    }

    public void removeTheNewFolder() {
        $(byXpath("//div[@data-id='/Новая папка']//div[@class='b-checkbox__box']")).click();
        $(byXpath("//span[@class='b-toolbar__btn__text b-toolbar__btn__text_pad' and contains(string(), 'Удалить')]")).click();
        $(byXpath("//button[@data-name='remove']")).click();
        $(byXpath("//div[@class='layer__footer']/button[@data-name='close']")).click();
    }
}