package pageObjects.vsemaykiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.baseObjects.BasePage;

import java.util.List;

public class CatalogPage extends BasePage {
    private final By listItems = By.xpath("//span[@class='_38-vDi9W']");

    private List<WebElement> getListOfItems(){
        waitVisibilityOfElement(listItems);
        return findElements(listItems);
    }

    public String getNameOfItem(int index){
         return getListOfItems().get(index).getText();
    }
    public int getNumberOfItemsOnPage(){
        return getListOfItems().size();
    }
}
