package Test;

import Resourse.BaseDriver;
import Resourse.Register;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import java.util.*;


import java.io.File;

/**
 * Created by Gaurav on 10/15/2022.
 */
public class BaseTest {
    Properties p = new Properties();

    static WebDriver driver= null ;




    @Parameters({"browsername", "url"})
    @BeforeTest
    public void StartBrowser(String browsername, String url) throws Throwable {
        String env = System.getProperty("config");
        driver = Register.StartBrowser(browsername, url);
        Register.dimension();
        BaseDriver baseDriver = new BaseDriver();
        baseDriver.setDriver(driver);

    }


    @AfterTest
    private void sendMail() {

        driver.quit();

    }


}
