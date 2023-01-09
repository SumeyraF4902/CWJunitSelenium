package Day7_Iframe_WindowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev2 {
    /*
    Go to URL: https://testproject.io/
Selenium’s 4 newWindow() method to open a new Window for TestProject’s Blog page.
https://blog.testproject.io/
URL'ye gidin: https://testproject.io/
TestProject'in Blog sayfası için yeni bir Pencere açmak için Selenium'un 4 newWindow() yöntemi.
https://blog.testproject.io/
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
    public void test() {

        driver.get("https://testproject.io/");
        WebDriver newWindow=driver.switchTo().newWindow(WindowType.WINDOW);//yeni pencere olusturuldu
        newWindow.get("https://blog.testproject.io/");// yeni pencereye yeni adres kondu


    }

}
