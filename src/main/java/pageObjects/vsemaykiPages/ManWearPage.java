package pageObjects.vsemaykiPages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

@Log4j
public class ManWearPage extends BasePage {
    private final By menTshirts = By.xpath("//span[text()='Футболки мужские']");
    private final By header = By.className("logo--2ltlz");

    public ManWearPage clickMenTshirts() {
        log.debug("Choose Man T-shirts");
        actions.moveToElement(findElement(header)).build().perform();
        click(menTshirts);
        return this;
    }
}
