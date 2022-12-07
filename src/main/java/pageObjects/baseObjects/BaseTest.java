package pageObjects.baseObjects;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import testNGUtils.ExtentReportListener;
import testNGUtils.InvokedMethodListener;
import testNGUtils.Listener;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import static driver.DriverManager.closeDriver;
import static driver.DriverManagerFactory.getManager;
import static propertyHelper.PropertyReader.getProperties;

@Listeners({Listener.class, InvokedMethodListener.class, ExtentReportListener.class})
@Log4j
public abstract class BaseTest {

    protected Properties properties;

    @BeforeTest()
    public void setUpDriver() {
        log.debug("Starting new web driver!");
        properties = getProperties();
        getManager(DriverManagerType
                .valueOf(properties.containsKey("browser") ? properties.getProperty("browser").toUpperCase() : "CHROME"));
    }

    protected <T> T get(Class<T> page) {
        T instance = null;
        properties = getProperties();
        getManager(DriverManagerType
                .valueOf(properties.containsKey("browser") ? properties.getProperty("browser").toUpperCase() : "CHROME"));
        try {
            instance = page.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return instance;
    }

    @AfterTest()
    public void stopDriver() {
        log.debug("Closing web driver!");
        closeDriver();
    }
}
