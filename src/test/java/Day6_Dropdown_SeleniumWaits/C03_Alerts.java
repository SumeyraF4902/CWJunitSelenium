package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
ACILAN KUTUCUKLARDIR. (JAVASCRIPT POP-UP LARIDIR)
TESTE DEVAM ETMEK ICIN UYARILAR KABUL EDILMELI VEYA IPTAL EDILMELIDIR.
4 SECENEK
DRİVER.SWİCTHTO.ALETR.ACCEPT()-CLICKING OK--> UYARIDA OK TIKLAR
 /DRİVER.SWİCTHTO.ALETR.DISMISS()- CLICKING CANGEL--->UYARIDA CANGEL TIKLAR
 / DRİVER.SWİCTHTO.ALETR.GETTEXT()-ALERTTEN TEXT ALMA-->UYARI MESAJI GETIRIR
 DRİVER.SWİCTHTO.ALETR.SENDKEYS()-->UYARIDA  TEXT GONDERIR
 */


//driver.switchTo().alert().accept();//ok demek
    //    driver.switchTo().alert().dismiss();//cancel demek
     //   driver.switchTo().alert().getText();//metni getirir
       // driver.switchTo().alert().sendKeys("");//metin kutusu doldurulur

import java.time.Duration;

public class C03_Alerts {//secilmesi gereken kutucuk   2 TANEDİR HTML VE JAVASCRİPT TİR
    //birbirinden ayiran temel fark ; alert cıktıgında sag click yapabiliyorsak yani incele kismi aciliyorsa bu HTML Alert tür
    WebDriver driver;
    @Before
    public void setUp(){
        //Driver ile ilgili her turlu initial(baslangic) islemi burada yapilir
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

    }
    @After
    public void tearDown() {
        // test sonrasinda driver kapatmak (varsa raporlari dosyalamak) icin kullanilir.
        driver.quit();
    }
    @Test
    public void alerts() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/delete_customer.php");

        WebElement idInput= driver.findElement(By.name("cusid"));
        idInput.sendKeys("123");
    driver.findElement(By.name("submit")).click();

    Thread.sleep(4000);//4 saniye bekle ekran hemen kapanmasin diye komut
    driver.switchTo().alert().accept();  //submit ve reset iki kutucuguda tikladi

    driver.switchTo().alert().accept();//accept kutucugu tıklıyor

    }
}
