package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Odev1 {

 /*   https://demoqa.com/select-menu sitesine gidin
            - <select> elementini locate edin
- <select> elementinin seceneklerini yazdirin
- Sirasiyla selectByIndex, selectByValue, selectByVisibleText methodlarini kullanarak;
    * Yellow (index)
    * Purple (value)
    * Black  (text)
    seceneklerini secin*/

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void tearDown() {
      driver.quit();
    }

    @Test
    public void selectByIndex() {

        driver.get("https://demoqa.com/select-menu");
       WebElement dropDown= driver.findElement(By.id("oldSelectMenu"));
//Locate edilen dropdown select objesine donusturuldu
       Select select= new Select(dropDown);
        //istenen index, value ve textler bulundu
       select.selectByIndex(3);
       select.selectByValue("4");
       select.selectByVisibleText("Black");


    }
    @Test
    public void  listeleme(){
        driver.get("https://demoqa.com/select-menu");
        Select select=new Select(driver.findElement(By.id("oldSelectMenu")));
        List<WebElement> renler=select.getOptions();
        for(WebElement renk:renler){
            System.out.println(renk.getText());
        }
    }
}