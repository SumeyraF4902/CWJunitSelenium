package Day09_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C09_FileDownLoad extends BaseTest {
    /*
    Go to URL: https://opensource-demo.orangehrmlive.com/
Login page valid credentials.
Download sample CSV file.
Verify if the file downloaded successfully.

URL'ye gidin: https://opensource-demo.orangehrmlive.com/
Giriş sayfası geçerli kimlik bilgileri.
Örnek CSV dosyasını indirin.
Dosyanın başarıyla indirilip indirilmediğini doğrulayın
     */
    @Test
    public void fileDownlooad(){
        //URL'ye gidin: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Giriş sayfası geçerli kimlik bilgileri.
        WebElement username= driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();// LOGIN Button Tiklandi

        //Örnek CSV dosyasını indirin.// Indirilecek dosyaya gitmek icin gerekli adimlar
        WebElement PIM = driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[2]"));
        PIM.click();

        WebElement configurationTab=driver.findElement(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']"));
        configurationTab.click();
        WebElement dataImport= driver.findElement(By.linkText("Data Import"));
        dataImport.click();
        WebElement doownloadLink= driver.findElement(By.className("download-link"));
        doownloadLink.click();
        // Indirilen dosyamizin path i
        String downloadPath="C:\\Users\\Muhsin Cevdet\\Downloads\\importData.csv";

        // Dosyanin indirildigini kontrol ediyoruz
        Assert.assertTrue("Indirilen dosya bulunamadi", Files.exists(Paths.get(downloadPath)));
    }

}
