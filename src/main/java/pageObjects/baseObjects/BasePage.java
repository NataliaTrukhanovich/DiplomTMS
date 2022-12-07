package pageObjects.baseObjects;

import driver.UIElement;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import static driver.DriverManager.getDriver;
import static propertyHelper.PropertyReader.getProperties;

@Log4j
public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected Properties properties;

    protected BasePage() {
        driver = getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        actions = new Actions(driver);
        properties = getProperties();
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    protected void load() {
        log.debug("Open page :: " + properties.getProperty("url"));
        driver.get(properties.getProperty("url"));
    }
    public void enter(By locator, String enterData) {
        log.debug("Enter text by locator :: " + locator);
        findElement(locator).clear();
        findElement(locator).sendKeys(enterData);
    }


    public void click(By locator) {
        verifyElementClickable(locator);
        log.debug("Click on element by locator :: " + locator);
        findElement(locator).click();
    }

    public void click(WebElement webElement) {
        new UIElement(driver, wait, webElement).click();
    }

    public Boolean elementNotExist(By by) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        for (int counter = 1; counter < 3; counter++) {
            log.debug("Wait element for not exist counter = " + counter);
            if (findElements(by).size() == 0) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                return true;
            }
            waitUntil(1);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return false;
    }

    protected void waitUntil(int second) {
        try {
            Thread.sleep(second * 3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void waitVisibilityOfElement(By locator) {
        log.debug("Wait visibility of element -> " + locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void verifyElementClickable(By locator) {
        log.debug("Verify element clickable -> " + locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}

