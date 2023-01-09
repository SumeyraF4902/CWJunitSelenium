package Day10_GarryHoca;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class deneme {
     WebDriver driver;
     @Before
     public void setup(){
          WebDriverManager.chromedriver().setup();
          driver=new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
          driver.manage().window().maximize();
     }
     @Test
     public void test(){
          driver.get("https://the-internet.herokuapp.com/windows");
          WebElement pagetext=driver.findElement(By.tagName("h3"));
          Assert.assertEquals(pagetext.getText(),"Opening a new window");
          Assert.assertEquals(driver.getTitle(),"The Internet");
          String firstHandle=driver.getWindowHandle();
          WebElement title=driver.findElement(By.linkText("Click Here"));
          title.click();
          Set<String> allWindoew=driver.getWindowHandles();
          String secondHandle="";
          for(String handle: allWindoew){
               if(!allWindoew.equals(firstHandle)){
                    secondHandle=handle;
                    break;
               }

          }
          driver.switchTo().window(secondHandle);
          Assert.assertEquals(driver.getTitle(),"New Window","bulunamadi");
          driver.switchTo().window(firstHandle);
          Assert.assertTrue(driver.getTitle().contains("The Internet"));





     }
}
