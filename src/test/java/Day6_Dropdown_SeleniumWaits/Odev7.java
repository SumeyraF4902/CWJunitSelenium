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

import java.time.Duration;

public class Odev7 {
    /*
    Go to URL: http://demo.automationtesting.in/Alerts.html
Click "Alert with OK" and click 'click the button to display an alert box:’
Accept Alert(I am an alert box!) and print alert on console.
Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
Cancel Alert  (Press a Button !)
Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
And then sendKeys «BootcampCamp» (Please enter your name)
Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.

URL'ye gidin: http://demo.automationtesting.in/Alerts.html****
"Tamam ile uyar"a tıklayın ve "bir uyarı kutusu görüntülemek için düğmeyi tıklayın:"a tıklayın.***
Uyarıyı Kabul Edin(Ben bir uyarı kutusuyum!) ve uyarıyı konsolda yazdırın.**
"Tamam ve İptal ile Uyar"a tıklayın ve "onay kutusunu görüntülemek için düğmeyi tıklayın"a tıklayın**
Uyarıyı İptal Et (Bir Düğmeye Basın!)**
"Textbox ile Uyarı"yı tıklayın ve "bilgi istemi kutusunu göstermek için düğmeyi tıklayın"ı tıklayın
Ardından «BootcampCamp» anahtarlarını gönderin (Lütfen adınızı girin)
Sonunda konsolda bu mesajı yazdırın "Merhaba BootcampCamp Bugün nasılsınız" iddiası bu mesajı
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
    public void test(){

        //Go to URL: http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //Click "Alert with OK" and click 'click the button to display an alert box:’
        WebElement alertOk= driver.findElement(By.xpath("//a[@class='analystic']"));
        alertOk.click();
        //Accept Alert(I am an alert box!) and print alert on console.
        WebElement alertBox= driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        alertBox.click();
        driver.switchTo().alert().getText();// uyarı mesaji getirildi
        driver.switchTo().alert().accept();// uyari ok tiklatildi
        //Accept Alert(I am an alert box!) and print alert on console.

        //Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
        driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();

        //Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
        driver.findElement(By.cssSelector("#CancelTab button")).click();

       // Cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();// uyarıda cikan cancel tiklar

        //Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
        driver.findElement(By.xpath(("//a[@href='#Textbox']"))).click();
        driver.findElement(By.xpath(("//button[@class='btn btn-info']"))).click();

        //And then sendKeys «BootcampCamp» (Please enter your name)
        driver.switchTo().alert().sendKeys("sumeyra");
        driver.switchTo().alert().accept();//uyarıda ok tiklandi

        //Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.
        WebElement message=driver.findElement(By.id("demo"));
        message.getText();
        System.out.println(message);

    }
}
