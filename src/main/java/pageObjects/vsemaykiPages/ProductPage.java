package pageObjects.vsemaykiPages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
@Log4j
public class ProductPage extends BasePage {

    private final By iconPopup = By.xpath("//div[@class='_3joS7Xdf KdtktrZO']//span[@class='_3t12687U']//*[name()='svg']");
    private final By popUpWindow = By.xpath("//div[@class='D_JihIwi ATOjLJuG']");
    private final By productName = By.xpath("//span[@class='product__info-name']");
    private final By addBtn = By.xpath("//button[@class='_3q1PZ3XG']");
    private final By moveToBasketBtn = By.xpath("//button[@class='_3q1PZ3XG _2EUUbTOK']");


    public ProductPage checkPopUp() {
        WebElement element = findElements(iconPopup).get(1);
        log.debug("Move to element :: "+ element);
        actions.moveToElement(element).build().perform();
        waitVisibilityOfElement(popUpWindow);
        Assert.assertTrue(findElement(popUpWindow).isDisplayed());
        actions.moveToElement(findElement(productName)).build().perform();
        return this;
    }

    public ProductPage addToBasket() {
        log.debug("Add to the basket");
        click(addBtn);
        return this;
    }

    public ProductPage moveToBasket() {
        log.debug("Move to the basket");
        click(moveToBasketBtn);
        return this;
    }

}
