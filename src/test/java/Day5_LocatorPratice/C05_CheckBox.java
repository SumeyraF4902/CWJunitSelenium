package Day5_LocatorPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class C05_CheckBox {
    //    Go to URL: https://demoqa.com/
//    Click on Elements.Öğeler'e tıklayın.
//    Click on Checkbox. Onay Kutusuna tıklayın.
//    Verify if Home checkbox is selected.  Ana Sayfa onay kutusunun seçili olup olmadığını doğrulayın.
//    Verify that "You have selected" is visible.   "Seçtiniz" ifadesinin görünür olduğunu doğrulayın.



WebDriver driver;


    @Before
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
}
    @After
    public void cleanup(){

        //driver.quit();
    }



    @Test
    public  void checkBox ()  {
    //   Go to URL: https://demoqa.com/
        driver.get("https://demoqa.com/");

    //    Click on Elements.Öğeler'e tıklayın.


        WebElement elementsButton = driver.findElement(By.xpath("//div[@class='card mt-4 top-card']"));
        elementsButton.click();


       List< WebElement> checkBox = driver.findElements(By.xpath("//li[@id='item-1']"));
         checkBox.get(0).click();

         WebElement homeWord=driver.findElement(By.className("rct-checkbox"));
         homeWord.click();

         WebElement visible=driver.findElement(By.xpath("//span[text()='you have selected:']"));
         Assert.assertTrue(visible.isDisplayed());
}
}
