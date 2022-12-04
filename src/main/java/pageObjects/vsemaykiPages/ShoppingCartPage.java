package pageObjects.vsemaykiPages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
@Log4j
public class ShoppingCartPage extends BasePage {
    private final By fullBasket = By.className("_3QL9fY_9");
    private final By emptyBasket = By.className("_3-XmRGcC");
    private final By deleteProductBtn = By.xpath("//div[@class='aQBZWaSX']");
    private final By numberOfProducts = By.xpath("//button//following-sibling::input[@type='number']");

    public ShoppingCartPage checkProductInBasket(){
        log.debug("Товары в корзине, если есть поле " + findElement(fullBasket).getText());
        Assert.assertEquals(findElement(fullBasket).getText(),"Итого");
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
