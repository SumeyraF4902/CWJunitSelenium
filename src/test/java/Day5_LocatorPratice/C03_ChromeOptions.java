package Day5_LocatorPratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C03_ChromeOptions {

    WebDriver driver;

    @Test
    public void chromeOptions(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
       // options.addArguments("headless");//goruntulenmeyen modda calisir
        options.addArguments("start-maximized");// goronur olarak calisir
        
        WebDriver driver= new ChromeDriver(options);

        //chorenme surucusunun cesitli ozelliklerini degistirmek icin kullanilir
        //Chromu maxsimum modda acma  start-maximized
        //mevcut uzantıları devre dısı bırakma   disable-extensions
        //acilir pencereleri devre didsi birakma-  disable-popup-blocking
        //birden fazla methodu vardir
        //gizli modda acmas.> incognito
        //goruntulenmeyen modda calisir  > headless

        //pro99 sitesinde ozellikleri bulabilirsin
    }
}
