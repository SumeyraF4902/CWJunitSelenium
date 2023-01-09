package Day09_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Odev3_File extends BaseTest{
    /*
    Go to URL: https://www.monsterindia.com/seeker/registration
Upload file.
url yr git, dosya yukle

     */
    @Test
    public void test3(){
        driver.get("https://www.monsterindia.com/seeker/registration");

    String filePath="C:\\Users\\Muhsin Cevdet\\Desktop\\TEAM_07\\deneme.txt";
        WebElement uploadResume= driver.findElement(By.id("file-upload"));
       uploadResume.sendKeys(filePath);

        WebElement result= driver.findElement(By.id("registrationDetails"));
        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(result.getText(),"deneme.txt");

    }
}
