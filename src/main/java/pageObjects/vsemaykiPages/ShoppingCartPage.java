package pageObjects.vsemaykiPages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
@Log4j
public class ShoppingCartPage extends BasePage {
    private final By fullBasket = By.xpath("//div[@class='bZSQdoZT']//child::a[@href='/cart']//following-sibling::span");
    private final By emptyBasket = By.xpath("//div[@id='content']//div[@class='container']//div//p");
    private final By deleteProductBtn = By.xpath("//div[@class='aQBZWaSX']");
    private final By numberOfProducts = By.xpath("//button//following-sibling::input[@type='number']");

    public ShoppingCartPage checkProductInBasket(){
        log.debug("Check items in the basket " + findElement(fullBasket).getText());
        Assert.assertTrue(findElement(fullBasket).isDisplayed());
        return this;
    }

    public ShoppingCartPage deleteProductFromBasket(){
        log.debug("Delete product from basket");
        click(findElements(deleteProductBtn).get(1));
        return this;
    }

    public ShoppingCartPage checkEmptyBasket(){
        log.debug(findElement(emptyBasket).getText());
        Assert.assertEquals(findElement(emptyBasket).getText(), "В Вашей корзине пока нет товаров");
        return this;
    }
    public ShoppingCartPage checkNumberOfProducts(String ourValue, String expectedValue) {
        log.debug("Set " + ourValue + " products");
        findElement(numberOfProducts).sendKeys(Keys.LEFT_CONTROL + "a", Keys.DELETE);
        log.debug("Check limit value if value = " + ourValue + " : ");
        findElement(numberOfProducts).sendKeys(ourValue);
        Assert.assertEquals(findElement(numberOfProducts).getAttribute("value"), expectedValue);
        return this;
    }
}
