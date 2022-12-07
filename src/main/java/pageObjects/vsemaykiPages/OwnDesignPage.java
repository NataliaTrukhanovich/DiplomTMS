package pageObjects.vsemaykiPages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

@Log4j
public class OwnDesignPage extends BasePage {
    private final By addImgBtn = By.xpath("//button[@id='addImage']");
    private final By addImgInput = By.xpath("//div[@data-autotest='LayersCreationTool']//input");
    private final String pathToFile = System.getProperty("user.dir") + "\\files\\Many Happies.jpg";
    private final By uploadedFile = By.xpath("//div[@data-autotest='Layer']");
    private final By closeDialogWindow = By.className("onboarding_close__Qt0ty");

    public OwnDesignPage clickCloseWindow() {
        log.debug("Close dialog window");
        waitUntil(5);
        if (!elementNotExist(closeDialogWindow)) {
            click(closeDialogWindow);
                   }
        return this;
    }

        public OwnDesignPage uploadImg() {
        log.debug("Upload file by locator ::" + addImgInput);
        findElement(addImgInput).sendKeys(pathToFile);
        return this;
    }

    public OwnDesignPage checkFileUploaded() {
        Assert.assertTrue(findElement(uploadedFile).isDisplayed());
        return this;
    }

}
