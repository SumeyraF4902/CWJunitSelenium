package Day2_WebElementLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Locator {
    WebDriver driver;


    @Before// METHODLARDAN ONCE Driveri acar
    public void setup() {//driver methodu
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();// BUNU HER METHODTA KULLANMAK İCİN BURADA DRİVERE
        //ATAYİP YUKARIDA ATAMA YAPMAM GEREKİYOR
        //sayfanin yuklenmesini bekliyoruz

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.linkedin.com/");//link edidini kullanacagimiz icin onu tanimladik

        driver.manage().window().maximize();// drivere mizi maximizehale getiriyoruz

    }

    @After
    public void tearDown() {// her methotdan sonra kapat demek
        // driver.quit();//driver kapatildi
    }


    // adress kutusunda gostermek istedigim mesajı yazarız
    @Test
    public void idLocator() {
        // id locator --"session_key"
        WebElement email = driver.findElement(By.id("session_key"));
        email.sendKeys("selamlar");
    }


    @Test // koyarsak method calisir hale gelir
    public void nameLocator() {
        //nameLocator--->session_password
        WebElement email = driver.findElement(By.name("session_password"));
        email.sendKeys("Sifre");
    }

    @Test
    public void classLocator() {
        //classLocator--->input_input

        WebElement email = driver.findElement(By.className("input_input"));
        email.sendKeys("sevgiler");
    }

    @Test
    public void tagLocator() {
        //tagLocator--->"input
        List<WebElement> emaiList = driver.findElements(By.tagName("input"));

        // 2. elementimiz email text alanimiz. bu yuzden bu elemani email degiskenine assign ettik
        WebElement email = emaiList.get(1);
        email.sendKeys("tagLocator");

    }

    @Test
    public void linkTextLocator() {
        //link text "Şifrenizi mi unuttunuz?"
        WebElement forgatPwd = driver.findElement(By.linkText("Şifrenizi mi unuttunuz?"));
        forgatPwd.click();
    }

    @Test
    public void partialLinkTextLocator() {
        //link text "Şifrenizi mi unuttunuz?" yerine sadece bir kisminida yazsak kabul ediyor
        WebElement forgatPwd = driver.findElement(By.linkText("Şifrenizi "));//yulkaridaki methodla ayni birazını yazsakta kabul ediyor
        forgatPwd.click();
    }

    @Test
    public void absoluteXpath() {
        //by.xpath > webElements bulmak iicİn güclü bir yöntem  path=yol
        WebElement email = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[2]/div[1]/input"));
        email.sendKeys("Sumeyra basarıyla tamamladin");
    }

    @Test
    public void relativeXpath() {
        //Xpath Locator--> //input[@name="session_key"]
        WebElement email = driver.findElement(By.xpath("//input[@name='session_key']"));
        email.sendKeys("Sumeyra basarıyla tamamladin");

    }

    @Test
    public void multipleAttributeXpath() {
        // xpath locator-->//input[@class='input__input'][@name='session_key']

        WebElement email = driver.findElement(By.xpath("//input[@class='input__input'][@name='session_key']"));
        email.sendKeys("Sumeyra basarıyla tamamladin");
    }

    @Test
    public void andOrXpath() {
        // xpath locator-->//input[@class='input__input' and @name='session_key']

        WebElement email = driver.findElement(By.xpath("//input[@class='input__input' and @name='session_key']"));
        email.sendKeys("Sumeyra basarıyla tamamladin");
    }
    @Test
    public void containsXpath() {
        // //*[contains(@id,"session")]

        WebElement email = driver.findElement(By.xpath("//*[contains(@id,'session')]"));
        email.sendKeys("Sumeyra basarıyla tamamladin");
    }
}
