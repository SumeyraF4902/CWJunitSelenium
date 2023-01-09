package Day7_Iframe_WindowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.html.HTMLDocument;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Odev3 {
    /*
    Go to URL: https://demoqa.com/browser-windows
    Click on the windows - "WindowButton"
    Click on all the child windows.
    Print the text present on all the child windows in the console.
    Print the heading of the parent window in the console.

    URL'ye gidin: https://demoqa.com/browser-windows
    Pencerelere tıklayın - "Pencere Düğmesi"
    Tüm alt pencereleri tıklayın.
    Konsoldaki tüm alt pencerelerde bulunan metni yazdırın.
    Ana pencerenin başlığını konsolda yazdırın.*/

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
    public void testOdev3(){
        driver.get("https://demoqa.com/browser-windows");
        String mainWindow=driver.getWindowHandle();
        driver.findElement(By.id("tabButton")).click();
        driver.findElement(By.id("windowButton")).click();

        Set<String>windows=driver.getWindowHandles();

        Iterator<String> openWindows=windows.iterator();
        while (openWindows.hasNext()) {
        driver.switchTo().window(openWindows.next());
        if(!driver.getWindowHandle().equals(mainWindow)){
        System.out.println(driver.findElement(By.tagName("body")).getText());}}

        // Ana pencerenin başlığını konsolda yazdırın.*
        driver.switchTo().window(mainWindow);
        System.out.println(driver.getTitle());

    }
}
