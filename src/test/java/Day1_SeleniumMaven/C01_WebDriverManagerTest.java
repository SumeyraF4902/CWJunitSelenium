package Day1_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriverManagerTest {
    // Set Path.
// Create chrome driver.
// Maximize the window.
// Open google home page https://www.google.com/
// Verify that you are Google in the title.

    public static void main(String[] args) {

        //System . setProperty("") yerine daha kisa yolu
        //WebDriverManager classini kullanarak  chromedriver binary lerimizi indirdik
        WebDriverManager.chromedriver().setup();

        //Drive objemizi oluşturduk
        WebDriver driver =new ChromeDriver();

        //window u maximize ettik
        driver.manage().window().maximize();

        //google anasayfamizi açtik
        driver.get("https://www.google.com/");

        //titlemizi aldik
        String title = driver.getTitle();

        //title  imizi dogruladik

        if(title.equals("Google")){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }
        //Driver imizi kapattik
        driver.quit();











    }
}
