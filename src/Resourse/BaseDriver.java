package Resourse;
import org.openqa.selenium.WebDriver;

/**
 * Created by Gaurav on 10/15/2022.
 */
public class BaseDriver {
    static   WebDriver driver= null;

    public static WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
