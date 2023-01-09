package Day3_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.K;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FilterOutputStream;
import java.time.Duration;

public class C02_Practice {
    //    Create the driver with BeforeClass and make it static inside the class.
//    Go to http://www.google.com
//    Type "Green Mile" in the search box and print the number of results.
//    Type "Premonition" in the search box and print the number of results.
//    Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
//    Close with AfterClass.
    static WebDriver driver;
  @BeforeClass
  public static void  createDriver(){
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  @Before
    public  void beforeEach(){//HER TEST ÖNCESİ CALISACAK SAYFA
      driver.get("https://www.google.com");

  }
  @AfterClass
    public static  void closeDriver(){//HER CLASS SONRASI ACILAN SAYFAYI KAPATMAK İCİN
      //driver.quit();
  }
  @Test
    public  void test01() {
      WebElement search= driver.findElement(By.name("q"));
      search.sendKeys("Green Mile"+ Keys.ENTER);

      WebElement results= driver.findElement(By.id("result-stats"));
      System.out.println(results.getText());//Yaklaşık 852.000.000 sonuç bulundu (0,40 saniye)
  }
 @Test
    public void test02() {
      WebElement search= driver.findElement(By.name("q"));
      search.sendKeys("Premonition"+ Keys.ENTER);
      WebElement result= driver.findElement(By.id("result-stats"));
     System.out.println(result.getText());//12.900.000 sonuc bulundu
  }
  @Test
  public void test03() {
    WebElement search= driver.findElement(By.name("q"));
    search.sendKeys("The Curious Case of Benjamin Button"+ Keys.ENTER);
    WebElement sonuc=driver.findElement(By.id("result-stats"));
    System.out.println(sonuc.getText());//Yaklaşık 5.610.000 sonuç bulundu (0,37 saniye)
  }
}
