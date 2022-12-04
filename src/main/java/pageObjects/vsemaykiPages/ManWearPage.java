package pageObjects.vsemaykiPages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;
@Log4j
public class ManWearPage extends BasePage {
    private final By menTshirts = By.xpath("//span[text()='Футболки мужские']//ancestor::a");

    public ManWearPage clickMenTshirts() {
        log.debug("Choose Man T-shirts");
        try {
            Thread.sleep(5000);
            click(menTshirts);
            return this;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
