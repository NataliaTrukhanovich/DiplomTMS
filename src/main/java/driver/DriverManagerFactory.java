package driver;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.extern.log4j.Log4j;

@Log4j
public class DriverManagerFactory {
    public static DriverManager getManager(DriverManagerType driverManagerType) {
        DriverManager driverManager = null;
        switch (driverManagerType) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
        }
        return driverManager;
    }
}
