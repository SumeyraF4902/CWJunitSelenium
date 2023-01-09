package Day8_WindowHandles_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C05_Actions extends BaseTest {

        @Test
        public void hoverOver(){// FAREMIZI ELEMENTIN UZERINE GETIP TIKLIYORUZ

            driver.get("https://www.amazon.com/");

            //SIPARISLERIME TIKLAMAK ICIN YAPILMASI GEREKENLER
            //1 HESAP VE LISTELER UZERINE GEL BEKLE
            //2 ACILINCA SIPARISLERI TIKLA
        WebElement accountsAndLists= driver.findElement(By.id("nav-link-accountList-nav-line-1"));


        //uzerrine gelip bekleme yapmak icin adimlar
            Actions actions= new Actions(driver);
            actions
                    .moveToElement(accountsAndLists)// HESAP VE LISTELER UZERINE bekleme yapiliyor
                    .click(driver.findElement(By.id("nav_prefetch_yourorders")))// Siparişlerim id alindı ve tiklandi
                    .perform();

            Assert.assertEquals("Amazon Sign-In" , driver.getTitle());

        }
}
