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
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocator {
    // Go to http://www.bestbuy.com siteye git
// Verify( dedimi Assert kullanmamiz gerektigini anliyoruz) that the page title contains "Best" Also, using Relative Locator.title  best  kelimesi iceriyor mu kontrol et
// LogoTest  Verify if the BestBuy logo is displayed.
// mexicoLinkTest  Verify if the link is displayed. görüntülenip görüntülenmediğini verir=displayed

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
        //test sonrasinda driver kapatmak (varsa raporları dosyalamak) icin kullanilir
       // driver.quit();
        }
    @Test
    public void RelativeLocator(){

        driver.get("http://www.bestbuy.com");//siteye gidildi

        Assert.assertTrue("Title Best kelimesini icermiyor",driver.getTitle().contains("Best"));// best kelimesini iceriyormu
        //icermiyorsa mesaj yazacak   yani test basarisiz olursa;"Title Best kelimesini icermiyor" diyecek.
        //getTitle sitenin title sini verir

        // LogoTest  Verify if the BestBuy logo is displayed.  logo locate ediliyor

        By logoLacator=RelativeLocator.with(By.tagName("img")).above(By.xpath("//div[text()='Hello!']"));//above = ustunde
        //bestbuy logosu hello yazisinin ustunde.... adres tarifi yaptik daha sonra alttakiyle buldurduk
         WebElement logo=driver.findElement(logoLacator);
         Assert.assertTrue(logo.isDisplayed());//logonun goruntulenip goruntulenmedigini kontrol ettik

        // mexicoLinkTest  Verify if the link is displayed.  mexsico linkinin sayfada görüntülenip görüntülenmediğini verir=displayed
        By mexicoLinkLocator=RelativeLocator.with(By.tagName("a")).toLeftOf(By.xpath("//div[@lang='en']"+
                "//a[@class='us-link']"));
        WebElement mexicoLink=driver.findElement(mexicoLinkLocator);
        Assert.assertTrue(mexicoLink.isDisplayed());

    }




}
