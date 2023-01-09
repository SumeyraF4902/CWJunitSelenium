package Day7_Iframe_WindowHandles;

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

public class C01_iframe_Example {
    //frame = sayfa icinde baskabir sayfa
    /*
    iFrame etiketi kullanilarak olusturulur. sayfa icinde iframe'i -index, id/class, Webelement arasinda
    gecis yaparak ele alinir.
    -driver.swicthto().frame(3 secenek)
     */


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
        //  driver.quit();
    }
    @Test
    public void iframeExamplel(){

        //        Go to URL: https://the-internet.herokuapp.com/iframe
//        Verify the Bolded text contains "Editor"    text e Editor kelimesi varmi kontrol et
//        Locate the text box
//        Delete the text in the text box text box icindeki text silinecek onun yerine altaki yazıyı yaz
//        Type "Hi everyone"  yasısı yazılacak
//        Verify the text Elemental Selenium text is displayed on the page.
//**** text yazisi  "Your content goes here."
         driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement boldedText= driver.findElement(By.tagName("h3"));
        String text = boldedText.getText();
        Assert.assertTrue(text.contains("Editor"));

        driver.switchTo().frame(0);
        WebElement textbox= driver.findElement(By.id("tinymce"));

        textbox.clear();// kutunun ici silindi
       // textbox.findElement(By.tagName("p")).clear();// 2 yol silme islemi

        textbox.sendKeys("Hi everyone");// yazisi yazildi

        //sayfaya geri switch islemi yapilir iframe deki islem bitince bu islem yapilir
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.partialLinkText("Elemental")).isDisplayed());
    }
}
