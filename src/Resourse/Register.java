package Resourse;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;

/**
 * Created by Gaurav on 10/15/2022.
 */
public class Register {

    static WebDriver driver;



    public static WebDriver StartBrowser(String browsername, String URL) {
        String configDir = System.getProperty("config");
        if (browsername.equalsIgnoreCase("Firefox")) {
            File file = new File(configDir + "driver/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            driver = new FirefoxDriver();}
        else if (browsername.equalsIgnoreCase("Firefoxlinux")) {
            File file = new File("\\Aspire\\driver\\geckodriver");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            driver = new FirefoxDriver();
        } else if (browsername.equalsIgnoreCase("chrome")) {

            File file = new File("\\Aspire\\driver\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");


            try {
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                driver = new ChromeDriver();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Open Browser");
        }
        else if (browsername.equalsIgnoreCase("chrome1")) {
            File file = new File(configDir + "driver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            driver = new ChromeDriver();




        } else if (browsername.equalsIgnoreCase("IE")) {
            driver = new InternetExplorerDriver();
        } else if (browsername.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        }



        driver.get(URL);

        return driver;
    }



    public static WebDriver dimension(){
        Dimension d = new Dimension(1300, 850);
        driver.manage().window().setSize(d);
        return driver;
    }

}
