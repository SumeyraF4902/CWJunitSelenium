package Day10_GarryHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import java.util.Set;

public class Task_06 extends BaseTest {
    /*
    1- https://the-internet.herokuapp.com/context_menu sitesine gidelim.
    2- Çizili alan üzerinde sağ click yapalım.
    3- Alert'te çıkan yazının "You selected a context menu" olduğunu test edelim.
    4- Tamam diyerek Alert'i kapatalım.
    5- Elemental Selenium linkine tıklayalım.
    6- Açılan sayfada h1 tagında "Elemental Selenium" yazdığını test edelim.
 */


    @Test
    public void test() {

        driver.get("https://the-internet.herokuapp.com/context_menu");

        //2- Çizili alan üzerinde sağ click yapalım.
        Actions action=new Actions(driver);
        WebElement box= driver.findElement(By.id("hot-spot"));
        action.contextClick(box).perform();//kutu uzerinde sag tiklandi

        //3- Alert'te çıkan yazının "You selected a context menu" olduğunu test edelim.
        Assert.assertEquals(driver.switchTo().alert().getText(),"You selected a context menu" );

        //4- Tamam diyerek Alert'i kapatalım.
        driver.switchTo().alert().accept();


        //5- Elemental Selenium linkine tıklayalım.
        String firstPageHandle= driver.getWindowHandle();//2 sayfaya gecmeden 1 sayfa handel edildi 6 soruda isimize yarayacak

        driver.findElement(By.linkText("Elemental Selenium")).click();

        //6- Açılan sayfada h1 tagında "Elemental Selenium" yazdığını test edelim.

        Set<String>allWindowPageHandles= driver.getWindowHandles();
        String secondPageHandle=  "";

        for(String each:allWindowPageHandles){
            if(!each.equals(firstPageHandle)) {
                secondPageHandle = each;
            }
        }
        driver.switchTo().window(secondPageHandle);

       Assert.assertEquals("İkinci sayfadaki text istenenden farklı.",driver.findElement(By.tagName("h1")).getText(),"Elemental Selenium");
        //Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Elemental Selenium", "İkinci sayfadaki text istenenden farklı.");
    }
}
