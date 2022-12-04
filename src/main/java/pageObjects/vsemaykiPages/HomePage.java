package pageObjects.vsemaykiPages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

@Log4j
public class HomePage extends BasePage {

    private final By elementLocation = By.xpath("//span[@class='_2t8wVAvg']");
    private final By dialogWindow = By.xpath("//div[@role='dialog']");
    private final By location = By.xpath("//div[@title='Казахстан']");
    private final By cookieBtn = By.xpath("//button[@class='button--3Rjqx button--primary--9plKk']");
    private final By searchIcon = By.xpath("//div[@class='_2ZLue7Fy']");
    private final By searchField = By.xpath("//div[@class='input-search--XRcYj focus--2Bgxp']//input[@data-autotest='InputSearch-5']");
    private final By product = By.xpath("//div[@data-autotest-design='3034333']");
    private final By ownDesignProduct = By.xpath("//div[@data-autotest='Product']");
    private final By authorization = By.className("H23xa383");
    private final By registration = By.xpath("//div[@class='row']//button[@class='btn btn-link']");
    private final By login = By.xpath("//input[@name='login']");
    private final By password = By.xpath("//input[@name='pass']");
    private final By regBtn = By.xpath("//button[@class='btn btn-primary']");
    private final By errorMessage = By.xpath("//div[@class='invalid-feedback']");
    private final By submitCountry = By.xpath("//span[@data-autotest='component-4' and text()='Все верно']");
    private final By manWear = By.xpath("//div[@class='swiper-slide swiper-slide-active']");

    public HomePage open() {
        load();
        return this;
    }

    public HomePage clickCookies() {
        log.debug("Close cookies window");
        if (!elementNotExist(cookieBtn)) {
            click(cookieBtn);
        }
        return this;
    }

    public HomePage clickSubmitCountry(){
        log.debug("Submit country Belarus");
        if (!elementNotExist(submitCountry)) {
            click(submitCountry);
        }
        return this;
    }
    public HomePage chooseLocation() {
        click(elementLocation);
        log.debug("Check dialog window is displayed");
        Assert.assertTrue(findElement(dialogWindow).isDisplayed());
        log.debug("Choose location");
        click(location);
        return this;
    }

    public HomePage clickSearch() {
        click(searchIcon);
        return this;
    }

    public HomePage checkMaxLength() {
        enter(searchField, "zxcvbnmkjhgfdsaqwertzxcvbnmkjhgfdsaqwertzxcvbnmkjhgfdsaqwertfgdfhhg");
        log.debug("Значение в поле поиска: " + findElement(searchField).getAttribute("value"));
        log.debug("Количество символов в строке поиска: " + findElement(searchField).getAttribute("value").length());
        Assert.assertEquals(findElement(searchField).getAttribute("value").length(), 60);
        return this;
    }

    public HomePage clickProduct() {
        click(product);
        return this;
    }

    public HomePage clickOwnDesignProduct() {
        log.debug("Choose own design product");
        click(ownDesignProduct);
        return this;
    }

    public HomePage inputRegistrationData() {
        log.debug("Check invalid login data");
        click(authorization);
        click(registration);
        findElement(login).sendKeys("#@t.");
        findElement(password).sendKeys("11111");
        click(regBtn);
        return this;
    }

    public HomePage checkInvalidData() {
        log.debug("Check error message :: " + findElement(errorMessage).getText());
        Assert.assertEquals(findElement(errorMessage).getText(), "Ошибка регистрации");
        return this;
    }

    public HomePage clickManWear() {
        waitVisibilityOfElement(manWear);
        actions.moveToElement(findElement(manWear)).build().perform();
        log.debug("Choose Man Wear");
        click(manWear);
        return this;
    }
}
