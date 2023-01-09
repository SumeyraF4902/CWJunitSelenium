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

import java.time.Duration;
import java.util.List;

public class C04_Checkboxes {
    //    Go to https://the-internet.herokuapp.com/checkboxes
//    Locate the elements of checkboxes.
//    Then click on checkbox 1 if box is not selected.=secili
//    Then click on checkbox 2 if box is not selected.
//    Then verify that checkbox 1 is checked.
    WebDriver driver;

    @Before
    public void setup(){
        //driver ile ilgili her türlü initial (baslangıic)islemi burada yapilir
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20000));

    }
    @After
    public void tearDown(){
        //test sonrasinda driver kapatmak (varsa raporları dosyalamak) icin kullanilir
       // driver.quit();
    }
    @Test
    public void checkboxes(){
        driver.get("https://the-internet.herokuapp.com/checkboxes ");

       List< WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
       WebElement checkbox1=checkboxes.get(0);
       WebElement checkbox2=checkboxes.get(1);
       if(!checkbox1.isSelected()){// secili degilse tikliyoruz
           checkbox1.click();//checkbox1 tikla

       }
       if   (!checkbox2.isSelected()){// secili degilse tikliyoruz
               checkbox2.click();//checkbox2 tikla
       }
       //Checkbox ların secili oldugunun kontrolu yapildi
        Assert.assertTrue(checkbox1.isSelected());//checkbox1 in secili oldugnu kontrol ediyoruz
        Assert.assertTrue(checkbox2.isSelected());//checkbox2 in secili oldugnu kontrol ediyoruz

    }
}
