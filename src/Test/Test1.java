package Test;

import Main.Home;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by Gaurav on 10/15/2022.
 */
public class Test1 extends BaseTest {


    public Test1() throws Throwable {
    }


     @Test(priority = 1)
    public void TestCase1() throws Throwable{
        Home home= new Home(driver);
        home.setAll();
        home.setSearch("iphone 14 pro max phone");
         home.setFeature();
        home.setPricemin("100");
        home.setPricemax("2000");
         home.setSubmit();
        home.validateItemPrice();


    }



    @Test(priority = 2)
    public void TestCase2() throws Throwable{
        Home home= new Home(driver);
        home.setHome();
        home.setAll();
        home.setSearch("iPhone 14");
        home.setPricemin("100");
        home.setPricemax("2000");
        home.setSubmit();
        home.setFeatures();
        home.setSort();
        home.validateSorting();




    }

    @Test(priority = 3)
    public void TestCase3() throws Throwable{
        Home home= new Home(driver);
        home.setHome();
        home.setAll();
        home.setSearch("iPhone 14");
        home.setPricemin("100");
        home.setPricemax("2000");
        home.setSubmit();
        home.setSelectitem();
        home.setAddtocart();
        home.setCheckout();
        home.setValidateSigninPage();


    }





}
