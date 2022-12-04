package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

import static propertyHelper.PropertyReader.getProperties;

public class FirefoxDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        Properties properties = getProperties();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        webDriver.set(new FirefoxDriver(firefoxOptions.addArguments(properties.getProperty("browser.configs"))));
    }
}
