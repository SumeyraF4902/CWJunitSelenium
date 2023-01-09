package Day7_Iframe_WindowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev1 {
    /*
    Go to URL: http://demo.guru99.com/test/guru99home/**
Find the number of iframes on the page.**
Link to the fourth iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
Exit the iframe and return to the main page.
URL'ye gidin: http://demo.guru99.com/test/guru99home/**
Sayfadaki iframe sayısını bulun.**
Dördüncü iframe bağlantısı (JMeter Made Easy) (https://www.guru99.com/live Selenium project.html) buraya tıklayın.
iframe'den çıkın ve ana sayfaya dönün.
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
    public void İframe(){
        driver.get("http://demo.guru99.com/test/guru99home/");

        //Find the number of iframes on the page.
        List<WebElement>iframeElementSayisi=driver.findElements(By.xpath("//iframe"));
        int iframesize=iframeElementSayisi.size();
        System.out.println(iframesize);//12

        // 2 yol
        driver.findElements(By.xpath("//iframe")).size();
        // 3 yol
        System.out.println("driver.findElements(By.tagName(\"iframe\")).size() = " + driver.findElements(By.tagName("iframe")).size());//12

     //Link to the fourth iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
       driver.switchTo().frame("a077aa5e");
       driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();

       //Exit the iframe and return to the main page.
        driver.switchTo().defaultContent();
        driver.close();

    }
}
