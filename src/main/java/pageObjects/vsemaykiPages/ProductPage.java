package pageObjects.vsemaykiPages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

@Log4j
public class ProductPage extends BasePage {

    private final By iconPopup = By.xpath("//span[@data-place]//following-sibling::span");
    private final By popUpWindow = By.xpath("//div[@class='D_JihIwi ATOjLJuG']");
    private final By productName = By.xpath("//span[@class='product__info-name']");
    private final By addBasketBtn = By.xpath("//div[@class='HYMmu_O3 THepThzB row']//button");
    private final By moveBasketBtn = By.xpath("//div[@class='HYMmu_O3 THepThzB row']//button[text()='Перейти в корзину']");


    public ProductPage checkPopUp() {
        waitVisibilityOfElement(iconPopup);
        WebElement element = findElements(iconPopup).get(1);
        waitUntil(1);
        log.debug("Move to element :: " + element);
        actions.moveToElement(element).build().perform();
        waitUntil(1);
        waitVisibilityOfElement(popUpWindow);
        Assert.assertTrue(findElement(popUpWindow).isDisplayed());
        actions.moveToElement(findElement(productName)).build().perform();
        return this;
    }

    public ProductPage addToBasket() {
        log.debug("Add to the basket");
        click(addBasketBtn);
        return this;
    }

    public ProductPage moveToBasket() {
        log.debug("Move to the basket");
        waitUntil(3);
        click(moveBasketBtn);
        return this;
    }

}
