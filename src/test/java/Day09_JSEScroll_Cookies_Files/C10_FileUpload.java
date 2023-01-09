package Day09_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class C10_FileUpload extends BaseTest {
    /*
    Go to URL: https://the-internet.herokuapp.com/upload
Find the path of the file that you want to upload.
Click on Upload button.
Verify the upload message.
URL'ye gidin: https://the-internet.herokuapp.com/upload
Yüklemek istediğiniz dosyanın yolunu bulun.
Yükle düğmesine tıklayın.
Yükleme mesajını doğrulayın.

Boolean isPresent = driver.findElements().size() > 0  kullan axception atmaz  0 verir
     */
    @Test
    public void fileUpload()  {
        driver.get("https://the-internet.herokuapp.com/upload");

        //Upload edilecek dosyamizi seciyoruz
        WebElement dosyaSec= driver.findElement(By.id("file-upload"));
        dosyaSec.sendKeys("C:\\Users\\Muhsin Cevdet\\Desktop\\fileExist.png");//click islemi sendkeysle gerceklesti

        // Upload butonuna basiyoruz
        WebElement uploadFile=driver.findElement(By.id("file-submit"));
        uploadFile.click();

        // Upload edilme mesajinin goruntulendigini dogruluyoruz
        WebElement uploadedMessage=driver.findElement(By.tagName("h3"));

        Assert.assertTrue(uploadedMessage.isDisplayed());//messaj gorunuyor mu
        Assert.assertEquals("File Uploaded!", uploadedMessage.getText());

    }
}
