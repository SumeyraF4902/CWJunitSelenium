package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Odev3 {
    /*
    https://demoqa.com/select-menu sitesine gidin
- multiple <select> elementini locate edin
- getOptions(), getFirstSelectedOption(), getAllSelected() methodlarini kullanmak adina:
    * Farkli secimler yaparak methodlarinizi kullanin ve Assertion yapmayi unutmayin
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
    public void selectIndex() {
        driver.get(" https://demoqa.com/select-menu");
        Select select=new Select(driver.findElement(By.id("cars")));

        //getOptions()
        List<WebElement>options=select.getOptions();
        // getOptions() metodu select elementinin tum seceneklerini (optionlarini) bir liste icerisinde bize verir
        for(WebElement option : options){
            System.out.println("GETOPTIONS METHODU");
            System.out.println(option.getText());
            // volvo--Saab--Opel--Audi  getirildi

            //option goruntulenip goruntulenmedigini sorguladık
            Assert.assertTrue(option.isDisplayed());
        }

        //getFirstSelectedOption()      secilenlerin indeksi once olani  getirir

        Select select1=new Select(driver.findElement(By.id("cars")));

        select1.selectByVisibleText("Audi");
        select1.selectByIndex(0);
        select1.selectByValue("opel");
        WebElement firstOption=select1.getFirstSelectedOption();
        System.out.println("GETFIRSTOPTION METHODU");
        System.out.println(firstOption.getText());
        //  0 indexte Volvo  oldugu icin Volvo getirildi

        //getAllSelected()   sectiklerimizin tamamini bize verir
        Select select2=new Select(driver.findElement(By.id("cars")));
        select2.selectByIndex(3);
        select2.selectByValue("volvo");
        select2.selectByVisibleText("Opel");
        List<WebElement>getSelect=select2.getAllSelectedOptions();
        System.out.println("GETALLSELECTEDOPTIONS METHODU");
        getSelect.forEach(t-> System.out.println(t.getText()));
            //sectigimiz 3 option u getirir
        //Volvo---Opel --Audi

    }
}
