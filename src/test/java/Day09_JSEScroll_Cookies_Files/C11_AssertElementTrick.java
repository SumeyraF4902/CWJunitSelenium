package Day09_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class C11_AssertElementTrick extends BaseTest {
    @Test
    public void fileUpload()  {
        driver.get("https://the-internet.herokuapp.com/upload");

        //Upload edilecek dosyamizi seciyoruz
        WebElement dosyaSec= driver.findElement(By.id("file-upload"));
        dosyaSec.sendKeys("C:\\Users\\Muhsin Cevdet\\Desktop\\fileExist.png");//click islemi sendkeysle gerceklesti

        // Upload butonuna basiyoruz
        WebElement uploadFile=driver.findElement(By.id("file-submit"));
        uploadFile.click();


        //Yeniden implement edecegiz

        // // Elementin locator unu ozellikle yanlis yazip durumu nasil handle ettigimizi kontrol ediyoruz
       List< WebElement> uploadedMessageList=driver.findElements(By.tagName("h3"));


        Assert.assertEquals("Upload mesaji goruntulenemedi",1,uploadedMessageList.size());

        WebElement uploadedMessage= uploadedMessageList.get(0);

        Assert.assertTrue(uploadedMessage.isDisplayed());
        Assert.assertEquals("Mesajin texti istenşlen gibi goruntulenemiyor","File Uploaded",uploadedMessage.getText());

    }
}
