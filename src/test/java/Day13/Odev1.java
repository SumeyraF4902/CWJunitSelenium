package Day13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTestReport;

public class Odev1  {
    /*

Entring weight
Selecting kilograms
Selecting height in feet
Selecting height in inchs
Clicking on calculate
 Tasktaki her bir step icin lutfen log mesajlarini yazdirarak ilerleyiniz :)
Go to URL: https://healthunify.com/bmicalculator/
Ağırlık girilmesi
Kilogram seçimi
Feet cinsinden yükseklik seçimi
İnç cinsinden yükseklik seçimi
Hesapla'ya tıklayarak
     */
    WebDriver driver;
    @Test
    public void homeWorkLog(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        PropertyConfigurator.configure("log4j.properties");
        Logger logger= Logger.getLogger(Odev1.class.getName());
       

        logger.info("URL ye gidiliyor");
        driver.get("https://healthunify.com/bmicalculator/");

        logger.info("Entring weight");
        WebElement weight= driver.findElement(By.name("wg"));
        weight.sendKeys("100");

        logger.info("Selecting kilograms");
        WebElement birim= driver.findElement(By.name("opt1"));
        Select select=new Select(birim);
        select.selectByValue("kilograms");

        logger.info("Selecting height in feet");
        WebElement height= driver.findElement(By.name("opt2"));
        Select feet= new Select(height);
        feet.selectByValue("3");

        logger.info("Selecting height in inchs");
        WebElement height1= driver.findElement(By.xpath("//select[@name='opt3']"));
        Select inchs= new Select(height);
        inchs.selectByValue("3");

            logger.info("Clicking on calculate");
            WebElement calculateButton= driver.findElement(By.name("cc"));
            calculateButton.click();

            logger.info("Sonuc getiriliyor");
            WebElement orCms= driver.findElement(By.name("ht"));
        System.out.println("Or CMS  "+ orCms.getText());
        logger.error("listemiz okunamiyor");

        logger.info("sonuc getiriliyor");
        WebElement siUnits= driver.findElement(By.xpath("//input[@name='si']"));
        System.out.println(siUnits.getText());
        if(siUnits.getText().isEmpty()) {
            logger.info("listimiz boş test gecersiz");
        }else{ logger.error("Testimiz gecerli");
        }

        logger.info("sonuc getiriliyor");
        WebElement usiUnits= driver.findElement(By.name("us"));
        System.out.println(usiUnits.getText());
        logger.info("Testimiz gecerli");
        logger.error("Testimiz gecersiz");

        logger.info("sonuc getiriliyor");
        WebElement ukUnits= driver.findElement(By.name("uk"));
        System.out.println(ukUnits.getText());
        logger.error("Sonuc getirilemedi");

        WebElement resulT= driver.findElement(By.xpath("//input[@name='desc']"));
        System.out.println("Desc  "+resulT.getText());
        if(resulT.getText().isEmpty()) {
            logger.info("listemiz bos donuyor");
        } else {
            logger.error("degerler ortada");
        }

    }
}
