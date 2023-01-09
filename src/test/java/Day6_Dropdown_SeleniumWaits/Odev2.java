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

public class Odev2 {
    /*https://demoqa.com/select-menu sitesine gidin
            - Multiple select yapabileceginiz <select> elementini locate edin
- Birden fazla secim yapip secimlerinizi DOGRULAyin*/

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
       // driver.quit();
    }

    @Test
    public void selectByIndex() {

        driver.get("https://demoqa.com/select-menu");

        Select select=new Select(driver.findElement(By.id("cars")));

        select.selectByIndex(0);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(1);

        List<WebElement> renkler=select.getAllSelectedOptions();
        renkler.forEach(t-> System.out.println(t.getText()));
        System.out.println(select.isMultiple());
    }





}
