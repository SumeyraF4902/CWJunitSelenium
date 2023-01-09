package Day4_LocatorPratice;

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

import java.time.Duration;

public class HomeWork1 {
    //https://id.heroku.com/login sayfasına gidiniz.
//Bir mail adresi giriniz.
//Bir password giriniz.
//Login butonuna tıklayınız.
//"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
//Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
//Tüm sayfaları kapatınız.
WebDriver driver;

@Before
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

}
@After
    public void tearDown(){
    driver.quit();
}
@Test
    public void herokuSitesi() {//HERoku Sitesine gidildi
    driver.get("https://id.heroku.com/login ");

// mail adresine git ve mail gir

    driver.findElement(By.xpath("//*[@id='email']")).sendKeys("S1.oz@gmail.com");

    //password giriniz ve login butonuna tiklayiniz
    driver.findElement(By.cssSelector("input[id='password']")).sendKeys("123456" + Keys.ENTER);

// test görünür ise " Kayıt Yapılamadı "  yazdir, eger gorunur degilse "  Kayıt Yapıldı" yazdir

    WebElement gorunduMu= driver.findElement(By.xpath("//*[@name='commit']"));
    Assert.assertTrue(gorunduMu.isDisplayed());

    if(gorunduMu.isDisplayed()==true){
        System.out.println("kayit yapilamadi");
    }else System.out.println("Kayit yapildi");
}
}
