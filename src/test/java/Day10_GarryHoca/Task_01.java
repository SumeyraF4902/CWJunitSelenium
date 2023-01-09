package Day10_GarryHoca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class Task_01 extends BaseTest {
    /*
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ● Bir method oluşturun: acceptAlert
        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının "You successfully clicked an alert" olduğunu test edin.
    ● Bir method oluşturun: dismissAlert
        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının "successfuly" içermediğini test edin.
    ● Bir method oluşturun: sendKeysAlert
        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin içerdiğini doğrulayın.
 */
//Bir method oluşturun: acceptAlert.
    @Test
    public void acceptAlert() {
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //1. butona tıklayın,
        WebElement jsAlert= driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        // uyarıdaki OK butonuna tıklayın
        jsAlert.click();
        driver.switchTo().alert().accept();// uyaridaki oka tiklar

        // ve result mesajının  "You successfully clicked an alert" olduğunu test edin.
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You successfully clicked an alert");
    }
    //Bir method oluşturun: dismissAlert
    @Test
    public void dismissAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //○ 2. butona tıklayın,
        WebElement jsConfirm= driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();

        // uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().accept();// uyaridaki oka tiklar

        // ve result mesajının "successfuly" içermediğini test edin.
        Assert.assertFalse(driver.findElement(By.id("result")).getText().contains("successfuly"));
    }
    //Bir method oluşturun: sendKeysAlert
    @Test
    public void sendKeysAlert() {
       driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 3. butona tıklayın,
        WebElement jsPrompt= driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();
        // uyarıdaki metin kutusuna isminizi yazin,
       driver.switchTo().alert().sendKeys("Sümeyra");// isim gonderildi

        // OK butonuna tıklayın
        driver.switchTo().alert().accept();// uyaridaki oka tiklar
        // ve result mesajında isminizin içerdiğini doğrulayın.
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("Sümeyra"));
    }
}
