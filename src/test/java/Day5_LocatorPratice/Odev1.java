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

public class Odev1

{//Go to URL: https://demoqa.com/radio-button
//Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
//Her bir seçenek seçildiğinde aşağıda çıkan text’leri konsolda yazdırınız.


    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @After
    public void tearDown() {
        //test sonrasinda driver kapatmak (varsa raporları dosyalamak) icin kullanilir
        driver.quit();}

    @Test
    public void test() {
        driver.get("https://demoqa.com/radio-button");
        WebElement yesRadio = driver.findElement(By.xpath("//label[text()='Yes']"));
        yesRadio.click();
        System.out.println(driver.findElement(By.xpath("//p[@class='mt-3']")).getText());
        WebElement impressiveRadio = driver.findElement(By.xpath("//label[text()='Impressive']"));
        impressiveRadio.click();
        System.out.println(driver.findElement(By.xpath("//p[@class='mt-3']")).getText());
        WebElement noRadio = driver.findElement(By.xpath("//label[text()='No']"));
        noRadio.click();
        if (!noRadio.isEnabled()) {
            System.out.println("no seçilemiyor.");

        }
    }

    }

