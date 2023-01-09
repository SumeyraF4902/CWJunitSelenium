package Day8_WindowHandles_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C02_Actions extends BaseTest {
    @Override
    public void tearDown() {}


    @Test
    public void doubleClick(){

        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickBtn= driver.findElement(By.id("doubleClickBtn"));// double click me cagrıldı
        //doubleClickBtn ekranına gelen mesaji dogruulama icin;
        Actions actions= new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed());//  ekranda gorunuyor .mesaj dogrulandi
    }
    @Test
    public void rightClick(){
        driver.get("https://demoqa.com/buttons");

        //righClickBtn
       WebElement rightClickBtn= driver.findElement(By.id("rightClickBtn"));//rightClickBtn locate edildi
        Actions actions= new Actions(driver);//actions classtan ob
        // je urettik
        actions.contextClick(rightClickBtn).build().perform();//rightClickBtn butonu saga tiklandi.  build suan birsey yapmadi.perform(); tek basina calismazsa
        //build().perform()--> kullan
        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).isDisplayed());// rightClickBtn tiklandiginde mesaj gorunuyormu
}
    @Test
    public void click() {
        driver.get("https://demoqa.com/buttons");
// click me butonu lacate edildi
        WebElement clickBtn= driver.findElement(By.xpath("//{.='Click Me']"));//id degisir kodlardan olustugundan text ini aldik click
            // click me butonu tıklandi
        Actions actions= new Actions(driver);
        actions.click(clickBtn).perform();//click butonu cagirip tikladik

        //clikc buton tiklandiginde mesaj gorunuyormu kontrol ediliyor
        Assert.assertTrue(driver.findElement(By.id("dynamicClickMessage")).isDisplayed());
    }}

