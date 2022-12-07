package pageObjects.vsemaykiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.baseObjects.BasePage;

import java.util.List;

public class CatalogPage extends BasePage {
    private final By listItems = By.xpath("//div[@data-autotest='Product']");
    private final By product = By.xpath("//div[@data-autotest-design='1938947']//a//span");

    private List<WebElement> getListOfItems(){
        waitVisibilityOfElement(listItems);
        return findElements(listItems);
    }
public CatalogPage clickProduct(){
        click(product);
        return this;
}
    public String getNameOfItem(int index){
         return getListOfItems().get(index).getText();
    }
    public int getNumberOfItemsOnPage(){
        return getListOfItems().size();
    }
}
