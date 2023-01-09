package Day10_GarryHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.BaseTest;

import java.util.Set;

public class Task_04 extends BaseTest {
    /*
    ● https://the-internet.herokuapp.com/windows adresine gidin.
    ● Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
    ● Sayfa başlığının (title) "The Internet" olduğunu doğrulayın.
    ● Click Here butonuna basın.
    ● Açılan yeni pencerenin sayfa başlığının (title) "New Window" olduğunu doğrulayın.
    ● Sayfadaki textin "New Window" olduğunu doğrulayın.
    ● Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu doğrulayın.
*/

    @Test
    public void test() {

        driver.get("https://the-internet.herokuapp.com/windows");

        //Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        Assert.assertEquals("Text istenildigi gibi mi",driver.findElement(By.tagName("h3")).getText(),"Opening a new window");

        //    ● Sayfa başlığının (title) "The Internet" olduğunu doğrulayın.
        Assert.assertTrue("1. sayfadaki title istenen degerden farkli",driver.getTitle().contains("The Internet"));

        //    ● Click Here butonuna basın.
        String firstPageHandle = driver.getWindowHandle();//ana sayfa handle edildi

        driver.findElement(By.linkText("Click Here")).click();

        // ● Açılan yeni pencerenin sayfa başlığının (title) "New Window" olduğunu doğrulayın.
        Set <String> allWindowHandles = driver.getWindowHandles();// unil oldugu icin set olusturuldu

        String secondWindowHandle = "";// daha sonra atama yapmak icin bos window tanimlandi

        for (String each: allWindowHandles){
            if (!each.equals(firstPageHandle)){
                secondWindowHandle = each;// window iki atandi
            }
        }

        driver.switchTo().window(secondWindowHandle);// window2 ye gecildi

        Assert.assertEquals("2. sayfadaki title istenen değerden farklı.",driver.getTitle(), "New Window");

        //Sayfadaki textin "New Window" olduğunu doğrulayın.
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "New Window");


        //Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu doğrulayın.
        driver.switchTo().window(firstPageHandle);// bir onceki pencereye donuldu
        Assert.assertTrue("1. sayfadaki title istenen değerden bambaşka.",driver.getTitle().contains("The Internet"));}
}
