package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.K;
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

public class C02_Dropdown {
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
        //driver.quit();
    }
    @Test
    public void selectByIndex(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");
//Dropdown dan locate edildi
        WebElement drpDown=driver.findElement(By.name("country"));

        //Locate edilen dropdown select objesine donusturuldu
        Select  select= new Select(drpDown);

        select.selectByIndex(1);//ALGERIA

        //selectByIndex() methodu 0 ile baslar
    }
    @Test
    public void selectByValue(){
        //Dropdown dan locate edildi
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement drpDown=driver.findElement(By.name("country"));

        //Locate edilen dropdown select objesine donusturuldu
        Select  select= new Select(drpDown);

        select.selectByValue("TURKEY");

        //selectByIndex() methodu 0 ile baslar
        // selectByValue() metodu option elementlerinin value attribute unun degerine gore secim yapar.
        //getFirstSelectedOption() metodu secili olan ilk option elementini bize verir. (Sectigimiz ilk option degil !!!)
    }

    @Test
    public void selectByVisibleText(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        //Dropdown locate edildi
        WebElement drpDown=driver.findElement(By.name("country"));
//Locate edilen dropdown select objesine donusturuldu
        Select select= new Select(drpDown);

        select.selectByVisibleText("NEPAL");
    }
    @Test
    public void multpleSelect(){

        driver.get("https://output.jsbin.com/osebed/2");
        //Dropdown locate ediliyor
        Select select= new Select(driver.findElement(By.id("fruits")));

        System.out.println(select.isMultiple());//true

        select.selectByValue("apple");
        select.selectByIndex(3);//GRAPE

    }
    @Test
    public void getOption(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        Select select= new Select(driver.findElement(By.name("country")));
        // getOptions() metodu select elementinin tum seceneklerini (optionlarini) bir liste icerisinde bize verir
        List<WebElement> options=select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }
    @Test
    public void getFirstSelectedOption(){

        driver.get("https://output.jsbin.com/osebed/2");

        Select select= new Select(driver.findElement(By.id("fruits")));

        select.selectByIndex(3);//grape
        select.selectByIndex(2);//orange

        WebElement selectedOption=select.getFirstSelectedOption();//secilenlerin indeksi once olani  getirir   :orange
        System.out.println(selectedOption.getText());
    }
    @Test
    public void getAlSelectedlOptions(){


        driver.get("https://output.jsbin.com/osebed/2");

        Select select= new Select(driver.findElement(By.id("fruits")));
        select.selectByValue("banana");
        select.selectByValue("apple");
        List<WebElement> selectedOptions=select.getAllSelectedOptions();

        selectedOptions.forEach(x-> System.out.println(x.getText()));//lambda ile yapildi
     //   selectedOptions.stream.forEach(x-> System.out.println(x.getText()));
    }
}
