package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C06_Actions extends BaseTest {
    @Override
    public void tearDown() {

    }

    @Test
    public void keyboardActions(){

        driver.get("https://demoqa.com/auto-complete");
       WebElement input = driver.findElement(By.id("autoCompleteSingleInput"));

        // You are Exceptional yazısını yazdırın
        Actions actions =new Actions(driver);
        actions
                .click(input)
                .keyDown(Keys.SHIFT)// buyuk yazmak istedigin harf icin shifte bas
                .sendKeys("y")// harfi gonder   buyuk olur
                .keyUp(Keys.SHIFT)//shifti kaldir
                .sendKeys("ou are")// harfi gonder   kucuk olur
                .keyDown(Keys.SHIFT)/// buyuk yazmak istedigin harf icin shifte bas
                .sendKeys("e")// harfi gonder   buyuk olur
                .keyUp(Keys.SHIFT)//shifti kaldir
                .sendKeys("xceptional")//harfi gonder   kucuk olur
                .perform();//   You are Exceptional   yazdirir
}}


