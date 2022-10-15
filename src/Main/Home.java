package Main;
import net.bytebuddy.asm.Advice;
import org.checkerframework.checker.units.qual.min;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.grid.web.JarFileResource;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

/**
 * Created by Gaurav on 10/15/2022.
 */
public class Home {

    WebDriver driver;

    public Home(WebDriver driver1) {
        this.driver = driver1;


    }


    By all = By.xpath("//div[contains(@id,'nav-search-dropdown-card')]");
    By dropdown= By.xpath("//select[contains(@id,'searchDropdownBox')]");
    By search = By.xpath("//input[contains(@id,'twotabsearchtextbox')]");
    By feature = By.xpath("//li[contains(@id,'p_89')]");
    By pricemin = By.xpath("//input[contains(@id,'low-price')]");
    By pricemax = By.xpath("//input[contains(@id,'high-price')]");
    By submit = By.xpath("//input[@class='a-button-input']");
    By itemprice = By.xpath("(//span[@class='a-price-whole'])");
    By home = By.xpath("//a[contains(@aria-label,'Amazon')]");
    By features = By.xpath("//span[@class='a-dropdown-prompt'][contains(.,'Featured')]");
    By sort = By.xpath("//a[contains(.,'Price: High to Low')]");
    By addtocart = By.xpath("//input[contains(@name,'submit.add-to-cart')]");
    By checkout = By.xpath("//input[contains(@name,'proceedToRetailCheckout')]");
    By validatesigninpage = By.xpath("//h1[contains(.,'Sign in')]");


    public void setAll() throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(all)).click();
        Thread.sleep(2000);
        WebElement element= driver.findElement(dropdown);
        JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("arguments[0].value='search-alias=electronics-intl-ship'", element);
        Thread.sleep(2000);
        element.click();

    }

    public void setSearch(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(search)).sendKeys(value);
        driver.findElement(search).sendKeys(Keys.ENTER);

    }

    public void setFeature() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(feature);

        for (int i = 0; i < elements.size(); i++) {

            String name = elements.get(i).getText();
            if (name.equalsIgnoreCase("Belkin")) {


                WebElement element = driver.findElement(By.xpath("//li[contains(@id,'p_89/" + name + "')]//i[@class='a-icon a-icon-checkbox']"));

                System.out.println(element);
                element.click();
                break;


            } else {
                System.out.println("element not found");
            }

        }
    }

    public void setPricemin(String min) throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(pricemin)).sendKeys(min);

    }

    public void setPricemax(String max) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(pricemax)).sendKeys(max);

    }

    public void setSubmit() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(submit).click();

    }


    public void validateItemPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        List<WebElement> elements = driver.findElements(itemprice);
        for (WebElement element : elements) {

            String price = element.getText();

            System.out.println(element.getText());

            int min = 100;
            int max = 2000;

            boolean flag = true;

            int price1 = Integer.parseInt(price.replace(",", ""));


            if (price1 >= min && price1 <= max) {

                flag = true;
            } else {
                flag = false;

            }

            Assert.assertTrue(flag = true);
        }


    }

    public void setHome() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(home)).click();

    }

    public void setFeatures() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(features)).click();

    }

    public void setSort() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(sort)).click();

    }

    public void validateSorting() {
        int previousprice=0;
        Boolean flag= true;


        List<WebElement> elements = driver.findElements(itemprice);
        for (int i=0; i<elements.size(); i++){
            String price =  elements.get(i).getText();
            int price1 = Integer.parseInt(price.replace(",", ""));

            System.out.println(price1);
            System.out.println(previousprice);

            if (previousprice!=0){

                if (price1<previousprice){
                    flag= true;
                    previousprice=price1;
                }
                else {
                    flag= false;
                }
            }
            else  {
                previousprice=price1;
                i++;
            }
        }
        Assert.assertTrue(flag= true);
    }

    public void setSelectitem() {


        List<WebElement> elements = driver.findElements(itemprice);

        elements.size();

        for (WebElement element : elements) {

            String price = element.getText();

            if (price != null) {

                element.click();
                break;
            } else {
                System.out.println("Phone is not available");
            }
        }


    }

    public void setAddtocart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.elementToBeClickable(addtocart)).click();

    }

    public void setCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();

    }


    public void setValidateSigninPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.presenceOfElementLocated(validatesigninpage)).isDisplayed();

        String element = driver.findElement(validatesigninpage).getText();

        Assert.assertEquals(element, "Sign in");

    }




    }
