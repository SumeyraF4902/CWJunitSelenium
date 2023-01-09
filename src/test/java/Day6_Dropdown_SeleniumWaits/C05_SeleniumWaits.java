package Day6_Dropdown_SeleniumWaits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseTest;

import java.time.Duration;

public class C05_SeleniumWaits extends BaseTest {
    //Explicit wait

    @Test
    public void webDriverWait(){

        driver.get("https://demoqa.com/interaction");

        // Adim 1 -> Webdriverwait objemiz olusturuldu
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        WebElement category = driver.findElement(By.xpath("(//div[@class='icon'])[2]"));


        //elementToBeClickable(Webelement)
        wait.until(ExpectedConditions.elementToBeClickable(category)).click();


        //elementToBeClickable(By)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'Practice Form')]"))).click();

////   COOOK   ONEMLIIIIII
        ///  methot olusturup o sekilde cagirabiliriz
       /*
        public static void waitAndClick(WebDriver driver,By locator){
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

            // daha sonra olusturdugun methodu asagidaki sekilde cagırabilirsin
            waitAndClick(driver,By.xpath("//div[contains(.,'Practice Form')]"))*/

        }







    }


