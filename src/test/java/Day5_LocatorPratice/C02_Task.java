package Day5_LocatorPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Task {
    //https://www.teknosa.com/ adresine gidiniz.
// Arama çubuğuna ''oppo'’ yazıp ENTER tıklayınız.
// Sonuç sayısını yazdırınız.
// Çıkan ilk ürüne tıklayınız.
// Sepete ekleyiniz.
// Sepetime gite tıklayınız.
// Konsolda "Sipariş Özeti" WebElement'inin text'ini yazdırınız.
// Alışverişi tamamlayınız.
// Son olarak "Teknosa'ya Hoş Geldiniz" WebElement'inin text'ini yazdırınız.
// Driver'ı kapatınız.
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
       //driver.quit();
    }

    @Test
    public void teknosatest(){
        driver.get("https://www.teknosa.com/ ");////https://www.teknosa.com/ adresine gidiniz.

        // Arama çubuğuna ''oppo'’ yazıp ENTER tıklayınız.
        WebElement aramaAlani=driver.findElement(By.name("s"));
        aramaAlani.sendKeys("oppo"+ Keys.ENTER);

        //sonuc sayisi yazdiriliyor
        WebElement sonuc=driver.findElement(By.xpath("//div[@class='plp-info']"));
        System.out.println(sonuc.getText());

        //ilk urune tiklanip sepete eklendi
        WebElement ilkUrun=driver.findElement(By.className("prd-link"));//İLK ÜRÜN ALINACAK
        //İLK URUN LOCATE EDİLDİ
        ilkUrun.click();

        //sepete ekle butonuna tiklandi
        WebElement sepeteEkle=driver.findElement(By.id("addToCartButton"));
        sepeteEkle.click();

        //Sepetime gite butonuna tıklayınız.
        WebElement sepetegit=driver.findElement(By.xpath("//a[@class='btn btn-secondary']"));
        sepetegit.click();

        //siparis özeti texti yazdirildi
        WebElement siparisOzet=driver.findElement(By.xpath("//div[@class='cart-sum-body']"));
        System.out.println(siparisOzet.getText());

        //Alisverisi tamamla butonuna basildi
        WebElement alisverisiTamamlaButone=driver.findElement(By.partialLinkText("Alışverişi Tamamla"));
        alisverisiTamamlaButone.click();
        //partialLinkText  > textin sagındaki solundaki boslukları temizler

        //teknosaya hosgeldinizi yazdirin
        WebElement hosgeldiniz=driver.findElement(By.className("lrp-title"));
        System.out.println(hosgeldiniz.getText());


    }
}
