package Day3_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.time.Duration;

public class Calısma {
  static  WebDriver driver;

  @BeforeClass
    public static void beforeClass(){
      WebDriverManager.chromedriver().setup();
      driver= new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  @Before
    public void  cretaDriver(){
      driver.get("https://www.youtube.com");
  }
@Test
   public void test01() {
    WebElement arama= driver.findElement(By.xpath("//input[@id='search']"));
      arama.sendKeys("Bi Bakıp Çıkıcaz Bursa"+ Keys.ENTER);

  }



}
