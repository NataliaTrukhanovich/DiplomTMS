package driver;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class DriverManager {

    {
        if (webDriver.get()==null){
            createDriver();
        }
    }
    public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    public abstract void createDriver();

    public static WebDriver getDriver(){
        webDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        webDriver.get().manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
        webDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        return webDriver.get();
    }
    public static void closeDriver() {
        if (webDriver!=null) {
            webDriver.get().close();
            webDriver.get().quit();
            webDriver.remove();
        }
    }
}
