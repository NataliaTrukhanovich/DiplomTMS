package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

import static propertyHelper.PropertyReader.getProperties;
@Log4j
public class ChromeDriverManager extends DriverManager{
    @Override
    public void createDriver() {
        WebDriver driver;
        Properties properties=getProperties();
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(chromeOptions.addArguments(properties.getProperty("browser.configs")));
        webDriver.set(driver);
    }
}
