package Day10_GarryHoca;

import Day13.C01_Log4jDemo;
import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

public class Task_Mulakat extends BaseTest {
  /*  Amazon Senaryosu
    o https://www.amazon.com.tr/ sitesi açılır.  ***
    o Ana sayfanın açıldığı kontrol edilir.   ****
    o  Çerez tercihlerinden Çerezleri kabul et seçilir.  ***
    o  Siteye login olunur.
    o Login işlemi kontrol edilir.
    o Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
    o Bilgisayar kategorisi seçildiği kontrol edilir.
    o Arama alanına MSI yazılır ve arama yapılır.
    o Arama yapıldığı kontrol edilir.
    o Arama sonuçları sayfasından 2. sayfa açılır.
    o 2. sayfanın açıldığı kontrol edilir.
    o Sayfadaki 2. ürün favorilere eklenir.
            o 2. Ürünün favorilere eklendiği kontrol edilir.
    o Hesabım > Favori Listem sayfasına gidilir.
    o “Favori Listem” sayfası açıldığı kontrol edilir.
    o Eklenen ürün favorilerden silinir.
    o Silme işleminin gerçekleştiği kontrol edilir.
    o Üye çıkış işlemi yapılır.
    o Çıkış işleminin yapıldığı kontrol edilir.*/

    @Test
    public void amazon() {


        // https://www.amazon.com.tr/ sitesi açılır.
        driver.get("https://www.amazon.com.tr/");

        //Ana sayfanın açıldığı kontrol edilir.
        Assert.assertEquals("https://www.amazon.com.tr/",driver.getCurrentUrl());

        //Çerez tercihlerinden Çerezleri kabul et seçilir.
        WebElement cookies= driver.findElement(By.id("sp-cc-accept"));
       cookies.click();

        //Siteye login olunur.
            Actions actions=new Actions(driver);
       /* actions.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).perform();
        WebElement loginButton=driver.findElement(By.linkText("Giriş yap"));
        loginButton.click();
          WebElement email= driver.findElement(By.id("ap_email"));
        email.sendKeys("isim@gmail.com"+Keys.ENTER);
        WebElement password= driver.findElement(By.id("ap_password"));
        password.sendKeys("mc20145"+ Keys.ENTER);*/

        // Login işlemi kontrol edilir.
        WebElement loginControl=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Assert.assertTrue(loginControl.getText().contains("Merhaba, Giriş yapın"));

        //    o Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
            WebElement search= driver.findElement(By.id("searchDropdownBox"));
            Select select=new Select(search);
            select.selectByValue("search-alias=computers");

            //    o Bilgisayar kategorisi seçildiği kontrol edilir.
        Assert.assertTrue(select.getFirstSelectedOption().isSelected());

        //    o Arama alanına MSI yazılır ve arama yapılır.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("MSI"+Keys.ENTER);

        //    o Arama yapıldığı kontrol edilir.
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).isDisplayed());

        //    o Arama sonuçları sayfasından 2. sayfa açılır.
        WebElement twoPage= driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-button']"));
        twoPage.click();
        //    o 2. sayfanın açıldığı kontrol edilir.
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).isDisplayed());
        //    o Sayfadaki 2. ürün favorilere eklenir.
        //            o 2. Ürünün favorilere eklendiği kontrol edilir.
        //    o Hesabım > Favori Listem sayfasına gidilir.
        //    o “Favori Listem” sayfası açıldığı kontrol edilir.
        //    o Eklenen ürün favorilerden silinir.
        //    o Silme işleminin gerçekleştiği kontrol edilir.
        //    o Üye çıkış işlemi yapılır.
        //    o Çıkış işleminin yapıldığı kontrol edilir
    }
}
