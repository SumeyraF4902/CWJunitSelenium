package Day09_JSEScroll_Cookies_Files;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Odev4_file extends BaseTest {
    /*
    // Go to https://the-internet.herokuapp.com/download
//  Download sample.png file
//  Then verify if the file downloaded successfully

adresine gidin
// Örnek.png dosyasını indir
// Ardından dosyanın başarıyla indirilip indirilmediğini kontrol edin

     */
    @Test
    public void odev4(){
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement file=driver.findElement(By.linkText("sample-zip-file.zip"));
        file.click();
        String samplePath="C:\\Users\\Muhsin Cevdet\\Downloads\\sample-zip-file.zip";
       Assert.assertTrue(Files.exists(Paths.get(samplePath)));
    }
}
