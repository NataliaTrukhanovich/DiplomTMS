package driver;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
@Log4j
public class UIElement implements WebElement {
    private final WebDriver webDriver;
    private final WebDriverWait wait;
    private final WebElement webElement;

    public UIElement(WebDriver webDriver, WebDriverWait wait, WebElement webElement) {
        this.webDriver = webDriver;
        this.wait = wait;
        this.webElement = webElement;
    }

    @Override
    public void click() {
        try {
            log.debug("Click from wrapper by element => " + webElement);
            webElement.click();
        } catch (ElementClickInterceptedException e) {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        }

    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {

    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
