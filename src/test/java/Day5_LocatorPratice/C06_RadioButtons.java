package Day5_LocatorPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButtons {
    //    Go to URL:  https://www.facebook.com/
//    Click on Create an Account button.
//    Then click on the radio buttons.
    // click kadin
    // click erkek
    // validate kadın secili degil erkek secili.


    WebDriver driver;

    @Before
    public void setup(){
        //driver ile ilgili her türlü initial (baslangıic)islemi burada yapilir
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
@After
public void tearDown(){
        driver.quit();
}
    @Test
    public void test(){
        driver.get("https://www.facebook.com/");
        WebElement registerButton= driver.findElement(By.xpath("//a[contains(@data-testid,'registration-form')]"));
        registerButton.click();

        WebElement kadinRadio= driver.findElement(By.xpath("//input[@name='sex'  and @value='1']"));
        WebElement erkekRadio= driver.findElement(By.xpath("//input[@name='sex'  and @value='2']"));
          kadinRadio.click();
          erkekRadio.click();
        Assert.assertTrue(!kadinRadio.isSelected());// kadin buttonu secili degilmi
        Assert.assertTrue(erkekRadio.isSelected());//erkek buttonu secilimi kontrol edildi
    }
}
