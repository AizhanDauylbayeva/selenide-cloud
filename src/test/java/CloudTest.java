import org.testng.Assert;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import pages.PicturesFolderCloudPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class CloudTest extends Base {

    @Test(priority = 0)
    public void createFolder() {
        cloudPage = inbox.openCloudPage();
        cloudPage.closePanel();
        cloudPage.createFolder();
        Selenide.refresh();
        $$(byXpath("//div[@class='b-filename__text']")).get(1).shouldHave(text("Новая папка"));
    }

    @Test(dependsOnMethods = "createFolder")
    public void removeTheFolder() {
        cloudPage.removeTheNewFolder();
        $$(byXpath("//div[@class='b-filename__text']")).get(1).shouldNotHave(text("Новая папка"));
    }

    @Test(priority = 2)
    public void doubleClickTest() {
        PicturesFolderCloudPage picturesFolderPage = cloudPage.openPicturesFolder();
        Assert.assertEquals(picturesFolderPage.getTitle(), "Pictures / Облако Mail.Ru", "The title is wrong");
    }

}
