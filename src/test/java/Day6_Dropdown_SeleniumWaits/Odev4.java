package Day6_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
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

public class Odev4 {
    /*
    Go to URL: https://opensource-demo.orangehrmlive.com/
Login with Username: Admin
Login with Password: admin123
Click login button
Click on PIM
Click on Employee List
    Employee Name -> Use Faker Class
    ID -> Use Faker Class
    Employment Status -> select by index: 2
    Include -> selectByVisibleText: Current and Past Employees
    Supervisor Name -> Use Faker Class
    Job Title ->selectByValue: IT Manager
    Sub Unit ->selectByValue: 3
Click search button
Verify text visible : "No Records Found"
URL'ye gidin: https://opensource-demo.orangehrmlive.com/   *
Kullanıcı Adı ile Giriş Yapın: Yönetici  *
Şifre ile Giriş Yapın: admin123   *
Giriş düğmesine tıklayın    *
PIM'e tıklayın   *
Çalışan Listesine tıklayın*
    Çalışan Adı -> Faker Sınıfı Kullan*
    Kimlik -> Faker Sınıfı Kullan*
    İstihdam Durumu -> dizine göre seçin: 2*
    Dahil Et -> selectByVisibleText: Mevcut ve Geçmiş Çalışanlar*
    Süpervizör Adı -> Faker Sınıfını Kullan
    İş Unvanı ->selectByValue: BT Yöneticisi
    Alt Birim ->selectByValue: 3
arama düğmesine tıklayın
Görünen metni doğrulayın: "Kayıt Bulunamadı"
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
    public <Employee> void url(){
        //URL'ye gidin: https://opensource-demo.orangehrmlive.com/   *
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Kullanıcı Adı ile Giriş Yapın: Yönetici  *
        WebElement userName= driver.findElement(By.name("username"));
        userName.sendKeys("Admin");

        //Login with Password: admin123
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        //Click login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Click on PIM
         driver.findElement(By.xpath("(//li[@class='oxd-main-menu-item-wrapper'])[2]")).click();
         driver.findElement(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item']")).click();

         Faker faker = new Faker();
         driver.findElement(By.xpath("//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']")).sendKeys(faker.name().firstName());
         driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']")).sendKeys(faker.idNumber().valid());
         driver.findElement(By.xpath("//div[@class='oxd-select-text-input']")).click();
         driver.findElement(By.xpath("//oxd-select-text-input']")).click();
         driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[2]")).sendKeys(faker.name().fullName());
         driver.findElement(By.xpath("//div[text()='IT Manager']")).click();
         driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[4]")).click();

        List<WebElement>links = driver.findElements(By.xpath("(//div[@class='oxd-select-text-input'])[4]"));
        // sayfalari actik
        links.get(2).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }
}
